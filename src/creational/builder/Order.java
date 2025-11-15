package creational.builder;

import java.util.List;

public class Order {
    private String customerName;
    private List<String> items;
    private double totalPrice;

    // Constructor for order object
    public Order(String customerName, List<String> items, double totalPrice) {
        this.customerName = customerName;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    // Display order details
    public void showOrder() {
        System.out.println("Customer: " + customerName);
        System.out.println("Items: " + items);
        System.out.println("Total: " + totalPrice + " T");
    }
}