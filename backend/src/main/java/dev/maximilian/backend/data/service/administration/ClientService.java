package dev.maximilian.backend.data.service.administration;

import dev.maximilian.backend.api.administration.ClientController;
import dev.maximilian.backend.data.entity.administration.Client;
import dev.maximilian.backend.repository.administration.ClientRepository;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;
    @Value("${spring.mail.username}")
    private String username;

    public ResponseEntity<Client> createClient(ClientController.RegisterRequest request) {
        try {
            Client client = Client.builder()
                    .username(request.username())
                    .email(request.email())
                    .password(passwordEncoder.encode(request.password()))
                    .build();

            UUID verificationId = UUID.randomUUID();
            while (clientRepository.findByVerificationId(verificationId.toString()).isPresent())
                verificationId = UUID.randomUUID();

            client.setVerificationId(verificationId.toString());

            clientRepository.save(client);

            MimeMessage message = javaMailSender.createMimeMessage();
            Context context = new Context();

            context.setVariable("clientName", client.getUsername());
            context.setVariable("verificationUid", client.getVerificationId());

            String process = templateEngine.process("email/confirmation-client.html", context);
            MimeMessageHelper helper = new MimeMessageHelper(
                    message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name()
            );
            helper.setTo(client.getEmail());
            helper.setFrom(new InternetAddress(username));
            helper.setSubject("Please confirm your email address");
            helper.setText(process, true);

            javaMailSender.send(message);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }


    public ResponseEntity<HttpStatus> verifyClient(String uid) {
        Client client = clientRepository.findByVerificationId(uid)
                .orElseThrow(() -> new RuntimeException("Invalid verification ID"));

        client.setVerified(true);
        clientRepository.save(client);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity<Client> regenerateApiKey(Optional<Client> client) {
        if (client.isPresent()) {
            UUID apiKey = UUID.randomUUID();
            while (clientRepository.findByApiKey(apiKey.toString()).isPresent())
                apiKey = UUID.randomUUID();

            client.get().setApiKey(apiKey.toString());
            clientRepository.save(client.get());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(client.get());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }
}
