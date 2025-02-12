package at.fhk.wes.controller;

import at.fhk.wes.domain.Cart;
import at.fhk.wes.domain.Product;
import at.fhk.wes.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/carts")
public class CartController {
    private final Logger logger = LoggerFactory.getLogger(CartController.class);
    private final Cart cart;
    private final ProductService productService;

    public CartController(ProductService productService) {
        this.cart = new Cart();
        this.productService = productService;
    }

    @PostMapping
    public Cart addToCart(@RequestBody Product product) {
        logger.info("started addToCart() method");
        if (cart.getProducts().stream().noneMatch(p -> p.getName().equals(product.getName()))) {
            cart.addProduct(product);
            productService.blockProducts(Set.of(product));
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
        cart.getProducts().removeIf(Objects::nonNull);
        return cart;
    }
}
