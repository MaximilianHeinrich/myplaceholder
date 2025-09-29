package dev.maximilian.backend.repository.administration;

import dev.maximilian.backend.data.entity.administration.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpaClientRepository")
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByUsername(String username);

    Optional<Client> findByVerificationId(String verificationId);

    Optional<Client> findByEmail(String email);

    Optional<Client> findByApiKey(String apiKey);

    Iterable<Client> findAllByVerifiedFalse();

}
