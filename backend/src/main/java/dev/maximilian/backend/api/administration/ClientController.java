package dev.maximilian.backend.api.administration;

import dev.maximilian.backend.data.entity.administration.Client;
import dev.maximilian.backend.data.service.administration.ClientService;
import dev.maximilian.backend.repository.administration.ClientRepository;
import dev.maximilian.backend.repository.person.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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

    //TODO: Remove this endpoint in production
    /** This endpoint is only for testing purposes to retrieve the API key of a client
    In production, the API key should be securely stored and not retrievable via an endpoint
    Clients should be provided their API key upon registration and be responsible for its storage
    Alternatively, implement a secure mechanism for API key retrieval if necessary **/
    @GetMapping("apiKey")
    public String getApiKey(@RequestParam String username) {
        Client client = clientRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return client.getApiKey();
    }

    public static record RegisterRequest(String username, String email, String password) {
    }

}
