package dev.maximilian.backend.api.administration;

import dev.maximilian.backend.data.entity.administration.Client;
import dev.maximilian.backend.data.service.administration.ClientService;
import dev.maximilian.backend.repository.administration.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/administration/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientRepository clientRepository;
    private final ClientService clientService;

    @PostMapping("register")
    public ResponseEntity<Client> register(@RequestBody RegisterRequest request) {
        return clientService.createClient(request);
    }

    @PostMapping("regenerate")
    public ResponseEntity<Client> regenerate() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<Client> client = clientRepository.findByUsername(authentication.getName());
        return clientService.regenerateApiKey(client);
    }

    public static record RegisterRequest(String username, String email, String password) {
    }

}
