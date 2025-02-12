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
    private final Map<UUID, Product> products = new HashMap<>();

    public ProductController() {
        Product p = new Product("MacBook Pro", "Apple MacBook Pro 16GB black", 1399.99);
        products.put(p.getId(), p);
        p = new Product("Dell XPS 13", "Dell XPS 13 Ultrabook with InfinityEdge display", 1199.99);
        products.put(p.getId(), p);
        p = new Product("HP Spectre x360", "HP Spectre x360 Convertible, 13.3-inch FHD touchscreen", 1299.99);
        products.put(p.getId(), p);
        p = new Product("Lenovo ThinkPad X1 Carbon", "Lenovo ThinkPad X1 Carbon, 14-inch display, Intel i7", 1499.99);
        products.put(p.getId(), p);
        p = new Product("Microsoft Surface Laptop", "Microsoft Surface Laptop 4, 13.5-inch PixelSense Display", 999.99);
        products.put(p.getId(), p);
    }

    @GetMapping
    public Set<Product> getProducts(@RequestParam(name = "filter") Optional<String> nameFilter,
                                    @RequestParam(name = "id") Optional<UUID> idFilter) {
        logger.info("started getProducts() method");
        return products.values().stream()
                .filter(Product::isAvailable)
                .filter(product -> nameFilter.map(s -> product.getName().contains(s)).orElse(true))
                .filter(product -> idFilter.map(s -> product.getId().equals(s)).orElse(true))
                .collect(Collectors.toSet());
    }

    @PutMapping("/block")
    public void blockProducts(@RequestBody Set<Product> products) {
        logger.info("started blockProducts() method");
        this.updateProductAvailability(products, false);
    }

    @PutMapping("/release")
    public void releaseProducts(@RequestBody Set<Product> products) {
        logger.info("started releaseProducts() method");
        this.updateProductAvailability(products, true);
    }

    private void updateProductAvailability(@RequestBody Set<Product> products, boolean available) {
        products.stream()
                .filter(product -> this.products.containsKey(product.getId()))
                .map(product -> this.products.get(product.getId()))
                .forEach(product -> product.setAvailable(available));
    }
}