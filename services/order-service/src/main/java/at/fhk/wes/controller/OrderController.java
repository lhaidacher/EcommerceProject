package at.fhk.wes.controller;

import at.fhk.wes.domain.Order;
import at.fhk.wes.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private final Set<Order> orders = new HashSet<>();

    @PostMapping
    public Order placeOrder(@RequestBody Set<Product> products) {
        logger.info("started placeOrder() method");
        Order order = new Order(products);
        orders.add(order);
        return order;
    }

    @GetMapping
    public List<Order> getOrders() {
        return orders.stream()
                .sorted(Comparator.comparing(Order::getCreatedAt))
                .toList();
    }
}
