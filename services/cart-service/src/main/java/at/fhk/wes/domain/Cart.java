package at.fhk.wes.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Cart {
    private final UUID id;
    private final Set<Product> products;
    private final Timestamp createdAt;

    public Cart() {
        this.id = UUID.randomUUID();
        this.products = new HashSet<>();
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public UUID getId() {
        return id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}
