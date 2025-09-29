package dev.maximilian.backend.data.service.administration;

import dev.maximilian.backend.data.entity.administration.Client;
import dev.maximilian.backend.repository.administration.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientDetailsService implements UserDetailsService {

    private final ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!client.isVerified()) {
            throw new UsernameNotFoundException("Account not verified");
        }

        return User.builder()
                .username(client.getUsername())
                .password(client.getPassword())
                .roles("USER")
                .build();
    }
}
