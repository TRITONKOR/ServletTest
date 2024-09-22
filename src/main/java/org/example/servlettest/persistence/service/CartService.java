package org.example.servlettest.persistence.service;

import java.math.BigDecimal;
import org.example.servlettest.persistence.entity.Cart;
import org.example.servlettest.persistence.entity.Product;

public interface CartService {

    Cart getNewCart();
    void addProduct(Cart cart, Product product, Integer quantity);
    void addProduct(Cart cart, Long prodId, Integer quantity);
    void delProduct(Cart cart, Product product, Integer quantity);
    BigDecimal getSum(Cart cart);
    void printCart(Cart cart);
    int getProductQuantity(Cart cart, Product product);
    int getProductQuantity(Cart cart, Long prodId);
}
