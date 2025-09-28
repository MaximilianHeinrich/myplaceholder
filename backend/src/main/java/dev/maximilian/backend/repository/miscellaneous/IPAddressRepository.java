package dev.maximilian.backend.repository.miscellaneous;

import dev.maximilian.backend.data.entity.miscellaneous.IPAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jpaIPAddressRepository")
public interface IPAddressRepository extends JpaRepository<IPAddress, Long> {
}
