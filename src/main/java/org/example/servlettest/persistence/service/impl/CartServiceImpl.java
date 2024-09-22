package org.example.servlettest.persistence.service.impl;

import java.math.BigDecimal;
import org.example.servlettest.persistence.entity.Cart;
import org.example.servlettest.persistence.entity.Product;
import org.example.servlettest.persistence.repository.ProductRepository;
import org.example.servlettest.persistence.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Bean
    @Override
    public Cart getNewCart() {
        return new Cart();
    }

    @Override
    public void addProduct(Cart cart, Product product, Integer quantity) {
        cart.addProduct(product, quantity);
    }

    @Override
    public void addProduct(Cart cart, Long prodId, Integer quantity) {
        cart.addProduct(productRepository.findById(prodId), quantity);
    }

    @Override
    public void delProduct(Cart cart, Product product, Integer quantity) {
        cart.delProduct(product, quantity);
    }

    @Override
    public BigDecimal getSum(Cart cart) {
        return cart.getSum();
    }

    @Override
    public void printCart(Cart cart) {
        System.out.println(cart.toString());
    }

    @Override
    public int getProductQuantity(Cart cart, Product product) {
        return cart.getCartMap().get(product);
    }

    @Override
    public int getProductQuantity(Cart cart, Long prodId) {
        return cart.getCartMap().get(productRepository.findById(prodId));
    }
}
