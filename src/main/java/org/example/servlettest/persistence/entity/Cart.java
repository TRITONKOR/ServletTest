package org.example.servlettest.persistence.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class Cart {
    private Map<Product, Integer> products;

    public Cart() {
        this.products = new HashMap<>();
    }

    public Map<Product, Integer> getCartMap() {
        return products;
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public void delProduct(Product product, int quantity) {
        if (products.containsKey(product)) {
            Integer currentQuantity = products.get(product);

            if (currentQuantity > quantity) {
                products.put(product, currentQuantity - quantity);
            } else {
                products.remove(product);
            }
        }
    }

    public BigDecimal getSum() {
        return products.entrySet().stream()
                .map(entry -> entry.getKey().getCost().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                '}';
    }
}
