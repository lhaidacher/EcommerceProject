package at.fhk.wes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Product {
    private final String name;
    private final String description;
    private final Double price;
    private boolean isAvailable;

    public Product(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.isAvailable = true;
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

    @JsonIgnore
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
