package org.example.servlettest.persistence.entity;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String title;
    private BigDecimal cost;

    public Product(Long id, String title, BigDecimal cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", title=" + title + ", cost=" + cost + "]";
    }
}
