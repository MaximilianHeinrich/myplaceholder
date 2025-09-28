package dev.maximilian.backend.repository.ecommerce;

import dev.maximilian.backend.data.entity.ecommerce.ECommerce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jpaECommerceRepository")
public interface ECommerceRepository extends JpaRepository<ECommerce, Long> {
}
