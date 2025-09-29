package dev.maximilian.backend.data.service.ecommerce;

import dev.maximilian.backend.data.entity.ecommerce.ECommerce;
import dev.maximilian.backend.repository.ecommerce.ECommerceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ECommerceService {

    private final ECommerceRepository eCommerceRepository;

    public List<ECommerce> findAllProducts() {
        return eCommerceRepository.findAll();
    }

    public Optional<ECommerce> findById(Long id) {
        return eCommerceRepository.findById(id);
    }

    public Optional<ECommerce> findByProductName(String productName) {
        return eCommerceRepository.findByProductName(productName);
    }

    public Optional<ECommerce> findByProductDescription(String description) {
        return eCommerceRepository.findByDescription(description);
    }

    public List<ECommerce> filterByPrice(Double minPrice, Double maxPrice) {
        return eCommerceRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<ECommerce> findByInStock(boolean inStock) {
        return eCommerceRepository.findByInStock(inStock);
    }

    public List<ECommerce> findByCurrencyCode(String currencyCode) {
        return eCommerceRepository.findByCurrencyCode(currencyCode);
    }

    public Long countProductsInStock() {
        return eCommerceRepository.countByInStock(true);
    }

    public Long countTotalValueOfProductsInStock() {
        return eCommerceRepository.sumPriceOfProductsInStock();
    }

    public List<ECommerce> findAllProductsWithLowStock(int threshold) {
        return eCommerceRepository.findByQuantityLessThan(threshold);
    }

}
