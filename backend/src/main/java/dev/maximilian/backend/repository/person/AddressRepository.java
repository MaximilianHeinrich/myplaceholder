package dev.maximilian.backend.repository.person;

import dev.maximilian.backend.data.entity.person.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jpaAddressRepository")
public interface AddressRepository extends JpaRepository<Address, Long> {
}
