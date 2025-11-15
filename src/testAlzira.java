import creational.abstractfactory.*;
import creational.builder.*;
import structural.bridge.*;

public class testAlzira {
    public static void main(String[] args) {
        System.out.println("Testing first 3 patterns\n");

        // Test Builder
        System.out.println("1. Builder Pattern:");
        Order order = new OrderBuilder()
                .setCustomerName("Test Customer")
                .addItem("Pizza", 4300)
                .addItem("Cola", 500)
                .build();
        order.showOrder();

        // Test Abstract Factory
        System.out.println("\n2. Abstract Factory Pattern:");
        AbstractFactory foodFactory = FactoryProducer.getFactory("food");
        Product pizza = foodFactory.getProduct("pizza");
        System.out.println("Created: " + pizza.getName() + " - " + pizza.getPrice() + " T");

        // Test Bridge
        System.out.println("\n3. Bridge Pattern:");
        PaymentSystem system = new SimplePaymentSystem();
        PaymentMethod payment = new OnlinePayment(system);
        payment.pay(4100);

        System.out.println("\nAll three patterns working!");
    }
}