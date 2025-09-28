package dev.maximilian.backend.repository.person;

import dev.maximilian.backend.data.entity.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jpaPersonRepository")
public interface PersonRepository extends JpaRepository<Person, Long> {
}
