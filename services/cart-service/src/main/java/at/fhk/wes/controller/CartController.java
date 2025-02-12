package at.fhk.wes.controller;

import at.fhk.wes.domain.Cart;
import at.fhk.wes.domain.Product;
import at.fhk.wes.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/carts")
public class CartController {
    private final Logger logger = LoggerFactory.getLogger(CartController.class);
    private final ProductService productService;
    private Cart cart;

    public CartController(ProductService productService) {
        this.cart = new Cart();
        this.productService = productService;
    }

    @PostMapping
    public Cart addToCart(@RequestBody Product product) {
        logger.info("started addToCart() method");
        if (cart.getProducts().stream().noneMatch(p -> p.getName().equals(product.getName()))) {
            productService.blockProducts(Set.of(product));
            cart.addProduct(product);
        }
        return cart;
    }

    @GetMapping
    public Cart getCart() {
        logger.info("started getCart() method");
        return cart;
    }

    @DeleteMapping
    public Cart cleanUpCart() {
        logger.info("started cleanUpCart() method");
        productService.releaseProducts(cart.getProducts());
        cart = new Cart();
        return cart;
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void cleanUpJob() {
        logger.info("started cleanUpJob() method");
        this.cleanUpCart();
    }
}
