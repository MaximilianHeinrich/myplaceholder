package dev.maximilian.backend.repository.person;

import dev.maximilian.backend.data.entity.person.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jpaOccupationRepository")
public interface OccupationRepository extends JpaRepository<Occupation, Long> {
}
