import structural.adapter.*;
import behavioral.strategy.*;
import behavioral.observer.*;

public class testSaltanat {
    public static void main(String[] args) {
        System.out.println("Testing last 3 patterns\n");

        // Test Adapter
        System.out.println("1. Adapter Pattern:");
        OldPrinter oldPrinter = new OldPrinter();
        NewPrinter printer = new ReceiptAdapter(oldPrinter);
        printer.print("Test receipt - Customer: Saltanat, Total: 4800 T");

        // Test Strategy
        System.out.println("\n2. Strategy Pattern:");
        DiscountContext discountContext = new DiscountContext();
        discountContext.setDiscountStrategy(new PercentageDiscount(15));
        double total = 4800;
        double discountedTotal = discountContext.apply(total);
        System.out.println("Total: " + total + " T");
        System.out.println("After 15% discount: " + discountedTotal + " T");

        // Test Observer
        System.out.println("\n3. Observer Pattern:");
        Restaurant restaurant = new Restaurant();
        Customer customer = new Customer("Saltanat");
        restaurant.addObserver(customer);
        restaurant.notifyObservers("Your order is ready for pickup!");

        System.out.println("\nAll three patterns working!");
    }
}