package org.example.servlettest.persistence.repository;

import java.util.ArrayList;
import java.util.List;
import org.example.servlettest.persistence.entity.Product;

public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
