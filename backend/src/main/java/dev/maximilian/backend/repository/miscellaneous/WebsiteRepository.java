package dev.maximilian.backend.repository.miscellaneous;

import dev.maximilian.backend.data.entity.miscellaneous.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jpaWebsiteRepository")
public interface WebsiteRepository extends JpaRepository<Website, Long> {
}
