package creational.builder;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    private String customerName;
    private List<String> items = new ArrayList<>();
    private double totalPrice;

    // Set customer name
    public OrderBuilder setCustomerName(String name) {
        this.customerName = name;
        return this;
    }

    // Add item to order
    public OrderBuilder addItem(String item, double price) {
        items.add(item);
        totalPrice += price;
        return this;
    }

    // Create final Order object
    public Order build() {
        return new Order(customerName, items, totalPrice);
    }
}