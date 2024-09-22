package org.example.servlettest.persistence;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.example.servlettest.persistence.repository.ProductRepository;

@WebServlet(urlPatterns = "")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,  IOException {

        ProductRepository productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
        //req.setAttribute("products", productRepository.getProducts());
        req.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(req, resp);
    }
}
