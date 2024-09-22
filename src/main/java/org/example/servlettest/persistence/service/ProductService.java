package org.example.servlettest.persistence.service;

import java.util.List;
import org.example.servlettest.persistence.entity.Product;

public interface ProductService {

    List<Product> getProductList();
    void saveOrUpdate(Product product);
    Product getProductById(Long id);
    void deleteById(Long id);
}
