package org.example.servlettest.persistence.context;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.example.servlettest.persistence.entity.Product;
import org.example.servlettest.persistence.repository.ProductRepository;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductRepository productRepository = new ProductRepository();
        for (int i = 1; i <= 10; i++) {
            productRepository.addProduct(new Product(i, "Product " + i, i * 10.0));
        }
        sce.getServletContext().setAttribute("productRepository", productRepository);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
