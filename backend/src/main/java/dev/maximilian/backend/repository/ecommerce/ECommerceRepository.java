package dev.maximilian.backend.repository.ecommerce;

import dev.maximilian.backend.data.entity.ecommerce.ECommerce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jpaECommerceRepository")
public interface ECommerceRepository extends JpaRepository<ECommerce, Long> {

    List<ECommerce> findByPriceBetween(Double minPrice, Double maxPrice);
    List<ECommerce> findByInStock(boolean inStock);
    List<ECommerce> findByCurrencyCode(String currencyCode);
    Long countByInStock(boolean inStock);
    Long sumPriceOfProductsInStock();
    List<ECommerce> findByQuantityLessThan(int threshold);
    List<ECommerce> findByProductNameContainingIgnoreCase(String productName);
    List<ECommerce> findByDescriptionContainingIgnoreCase(String description);
    java.util.Optional<ECommerce> findByProductName(String productName);
    java.util.Optional<ECommerce> findByDescription(String description);

}
