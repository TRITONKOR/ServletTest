import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import org.example.servlettest.persistence.config.AppConfig;
import org.example.servlettest.persistence.entity.Cart;
import org.example.servlettest.persistence.entity.Product;
import org.example.servlettest.persistence.service.impl.CartServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = AppConfig.class)
public class CartTest {
    @Autowired
    private CartServiceImpl cartService;

    private Cart cart;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setup() {
        cart = cartService.getNewCart();
        product1 = new Product(1L, "Apple", new BigDecimal("0.99"));
        product2 = new Product(2L, "Banana", new BigDecimal("1.29"));
    }

    @Test
    public void testAddProductToCart() {
        cart.addProduct(product1, 2);
        assertEquals(1, cart.getCartMap().size(), "У кошику має бути 1 продукт.");
        assertEquals(2, cart.getCartMap().get(product1), "Кількість продукту має бути 2.");
    }

    @Test
    public void testRemoveProductFromCart() {
        cart.addProduct(product1, 2);
        cart.delProduct(product1, 1);
        assertEquals(1, cart.getCartMap().get(product1), "Після видалення одного продукту має залишитися 1.");

        cart.delProduct(product1, 1);
        assertNull(cart.getCartMap().get(product1), "Продукт має бути видалений повністю з кошика.");
    }

    @Test
    public void testCartTotalSum() {
        cart.addProduct(product1, 2);
        cart.addProduct(product2, 1);

        BigDecimal total = cart.getSum();
        assertEquals(new BigDecimal("3.27"), total, "Загальна вартість кошика має бути правильною.");
    }
}
