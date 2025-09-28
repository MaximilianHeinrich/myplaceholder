package dev.maximilian.backend.repository.person;

import dev.maximilian.backend.data.entity.person.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jpaUserRepository")
public interface UserRepository extends JpaRepository<User, Long> {
}
