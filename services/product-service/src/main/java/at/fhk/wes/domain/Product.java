package at.fhk.wes.domain;

import java.util.UUID;

public class Product {
    private final UUID id;
    private final String name;
    private final String description;
    private final Double price;

    public Product(UUID id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}
