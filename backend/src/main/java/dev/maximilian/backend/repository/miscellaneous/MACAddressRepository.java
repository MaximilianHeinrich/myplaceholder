package dev.maximilian.backend.repository.miscellaneous;

import dev.maximilian.backend.data.entity.miscellaneous.MACAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jpaMACAddressRepository")
public interface MACAddressRepository extends JpaRepository<MACAddress, Long> {
}
