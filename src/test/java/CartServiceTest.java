import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import org.example.servlettest.persistence.config.AppConfig;
import org.example.servlettest.persistence.entity.Cart;
import org.example.servlettest.persistence.entity.Product;
import org.example.servlettest.persistence.repository.ProductRepository;
import org.example.servlettest.persistence.service.impl.CartServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = AppConfig.class)
class CartServiceTest {
    @Autowired
    private CartServiceImpl cartService;
    private ProductRepository productRepository;
    private Cart cart;
    private Product product1;

    @BeforeEach
    public void setup() {
        productRepository = mock(ProductRepository.class);
        cartService.setProductRepository(productRepository);
        cart = cartService.getNewCart();

        product1 = new Product(1L, "Apple", new BigDecimal("0.99"));
        when(productRepository.findById(1L)).thenReturn(product1);
    }

    @Test
    public void testAddProductUsingService() {
        cartService.addProduct(cart, 1L, 2);
        assertEquals(2, cart.getCartMap().get(product1), "Кількість продукту повинна бути 2.");
    }

    @Test
    public void testCartTotalSumUsingService() {
        cartService.addProduct(cart, 1L, 2);
        BigDecimal total = cartService.getSum(cart);
        assertEquals(new BigDecimal("1.98"), total, "Загальна сума повинна бути правильною.");
    }
}