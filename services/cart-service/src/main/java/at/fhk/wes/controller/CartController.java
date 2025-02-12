package at.fhk.wes.controller;

import at.fhk.wes.domain.Cart;
import at.fhk.wes.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {
    private final Logger logger = LoggerFactory.getLogger(CartController.class);
    private final Cart cart = new Cart();

    @PostMapping
    public Cart addToCart(@RequestBody Product products) {
        logger.info("started addToCart(Product) method");
        cart.addProduct(products);
        return cart;
    }

    @GetMapping
    public Cart getOrders() {
        return cart;
    }
}
