package dev.maximilian.backend.data.service.administration;

import dev.maximilian.backend.api.administration.ClientController;
import dev.maximilian.backend.data.entity.administration.Client;
import dev.maximilian.backend.repository.administration.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<Client> createClient(ClientController.RegisterRequest request) {
        try {
            Client client = Client.builder()
                    .username(request.username())
                    .email(request.email())
                    .password(passwordEncoder.encode(request.password()))
                    .build();

            clientRepository.save(client);  // Save the client

            return ResponseEntity.status(HttpStatus.OK).body(client);  // Return HTTP 201 Created status
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)  // Return HTTP 400 Bad Request if there was an error
                    .body(null);
        }
    }


}
