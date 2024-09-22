package org.example.servlettest.persistence.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.example.servlettest.persistence.entity.Product;
import org.springframework.stereotype.Repository;
import jakarta.annotation.PostConstruct;

@Repository
public class ProductRepository {
    private Map<Long, Product> productMap;

    @PostConstruct
    public void init() {
        productMap = new HashMap<>();
        saveOrUpdate(new Product(1L, "Apple", new BigDecimal("0.99")));
        saveOrUpdate(new Product(2L, "Banana", new BigDecimal("1.29")));
        saveOrUpdate(new Product(3L, "Orange", new BigDecimal("1.99")));
        saveOrUpdate(new Product(4L, "Mango", new BigDecimal("2.99")));
        saveOrUpdate(new Product(5L, "Pineapple", new BigDecimal("3.49")));
    }

    public void saveOrUpdate(Product product) {
        productMap.put(product.getId(), product);
    }

    public void deleteById(Long id) {
        productMap.remove(id);
    }

    public List<Product> findAll() {
        return productMap.values().stream().collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return productMap.values().stream().filter(product -> Objects.equals(product.getId(), id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
