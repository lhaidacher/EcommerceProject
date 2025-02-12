package at.fhk.wes.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Cart {
    private final UUID id;
    private final Set<Product> products;
    private final Timestamp createdAt;
    private Timestamp modifiedAt;

    public Cart() {
        this.id = UUID.randomUUID();
        this.products = new HashSet<>();
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.modifiedAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        modifiedAt = new Timestamp(System.currentTimeMillis());
        products.add(product);
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }
}
