package at.fhk.wes.controller;

import at.fhk.wes.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final Map<Integer, Product> products = new HashMap<>();

    public ProductController() {
        Product p = new Product("MacBook Pro", "Apple MacBook Pro 16GB black", 1399.99);
        products.put(p.getName().hashCode(), p);
        p = new Product("Dell XPS 13", "Dell XPS 13 Ultrabook with InfinityEdge display", 1199.99);
        products.put(p.getName().hashCode(), p);
        p = new Product("HP Spectre x360", "HP Spectre x360 Convertible, 13.3-inch FHD touchscreen", 1299.99);
        products.put(p.getName().hashCode(), p);
        p = new Product("Lenovo ThinkPad X1 Carbon", "Lenovo ThinkPad X1 Carbon, 14-inch display, Intel i7", 1499.99);
        products.put(p.getName().hashCode(), p);
        p = new Product("Microsoft Surface Laptop", "Microsoft Surface Laptop 4, 13.5-inch PixelSense Display", 999.99);
        products.put(p.getName().hashCode(), p);
    }

    @GetMapping
    public Set<Product> getProducts(@RequestParam(name = "filter") Optional<String> filter) {
        logger.info("started getProducts() method");
        return products.values().stream()
                .filter(Product::isAvailable)
                .filter(product -> !product.isSold())
                .filter(product -> filter.map(s -> product.getName().toLowerCase().contains(s.toLowerCase())).orElse(true))
                .collect(Collectors.toSet());
    }

    @PutMapping("/block")
    public void blockProducts(@RequestBody Set<Product> products) {
        logger.info("started blockProducts() method");

        products.forEach(product -> {
            Product p = this.products.get(product.getName().hashCode());
            if (p == null) throw new IllegalStateException("Product is not available.");
            else if (p.isSold()) throw new IllegalArgumentException("Product is already sold.");
            else if (!p.isAvailable()) throw new IllegalArgumentException("Product is already out of stock.");
            else p.setAvailable(false);
        });
    }

    @PutMapping("/release")
    public void releaseProducts(@RequestBody Set<Product> products) {
        logger.info("started releaseProducts() method");

        products.forEach(product -> {
            Product p = this.products.get(product.getName().hashCode());
            if (p == null) throw new IllegalStateException("Product is not available.");
            else if (p.isSold()) throw new IllegalArgumentException("Product is already sold.");
            else if (p.isAvailable()) throw new IllegalArgumentException("Product is already available.");
            else p.setAvailable(true);
        });
    }

    @PutMapping("/sell")
    public void sellProducts(@RequestBody Set<Product> products) {
        logger.info("started sellProducts() method");

        products.forEach(product -> {
            Product p = this.products.get(product.getName().hashCode());
            if (p == null) throw new IllegalStateException("Product is not available.");
            else if (p.isSold()) throw new IllegalArgumentException("Product is already sold.");
            else p.setSold(true);
        });
    }
}