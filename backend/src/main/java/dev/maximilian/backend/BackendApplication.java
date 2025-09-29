package dev.maximilian.backend;

import dev.maximilian.backend.repository.administration.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class BackendApplication {

    private final ClientRepository clientRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void deleteUnverified() {
        clientRepository.findAllByVerifiedFalse().forEach(client -> {
            if (!client.isVerified()) clientRepository.delete(client);
        });
    }

}
