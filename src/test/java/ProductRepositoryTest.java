import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;
import org.example.servlettest.persistence.config.AppConfig;
import org.example.servlettest.persistence.entity.Product;
import org.example.servlettest.persistence.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = AppConfig.class)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        productRepository.init();
    }

    @Test
    public void testFindAllProducts() {
        List<Product> products = productRepository.findAll();
        System.out.println(products);
        assertEquals(5, products.size(), "Має бути 5 продуктів після ініціалізації.");
    }

    @Test
    public void testFindProductById() {
        Product product = productRepository.findById(1L);
        assertNotNull(product);
        assertEquals("Apple", product.getTitle(), "Назва продукту з ID 1 повинна бути Apple.");
    }

    @Test
    public void testSaveOrUpdateProduct() {
        Product newProduct = new Product(6L, "Strawberry", new BigDecimal("4.99"));
        productRepository.saveOrUpdate(newProduct);

        Product fetchedProduct = productRepository.findById(6L);
        assertNotNull(fetchedProduct);
        assertEquals("Strawberry", fetchedProduct.getTitle(), "Назва нового продукту повинна бути Strawberry.");
    }

    @Test
    public void testDeleteProductById() {
        productRepository.deleteById(1L);
        assertThrows(RuntimeException.class, () -> productRepository.findById(1L), "Продукт має бути видалений.");
    }
}

