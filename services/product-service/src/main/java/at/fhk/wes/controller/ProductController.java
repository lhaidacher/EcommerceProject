package at.fhk.wes.controller;

import at.fhk.wes.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final List<Product> products = List.of(
            new Product(UUID.randomUUID(), "MacBook Pro", "Apple MacBook Pro 16GB black", 1399.99),
            new Product(UUID.randomUUID(), "Dell XPS 13", "Dell XPS 13 Ultrabook with InfinityEdge display", 1199.99),
            new Product(UUID.randomUUID(), "HP Spectre x360", "HP Spectre x360 Convertible, 13.3-inch FHD touchscreen", 1299.99),
            new Product(UUID.randomUUID(), "Lenovo ThinkPad X1 Carbon", "Lenovo ThinkPad X1 Carbon, 14-inch display, Intel i7", 1499.99),
            new Product(UUID.randomUUID(), "Microsoft Surface Laptop", "Microsoft Surface Laptop 4, 13.5-inch PixelSense Display", 999.99)
    );

    @GetMapping
    public List<Product> getProducts() {
        logger.info("started getProducts() method");
        return products;
    }
}
