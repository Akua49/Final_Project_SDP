import creational.abstractfactory.*;
import creational.builder.*;
import structural.bridge.*;
import structural.adapter.*;
import behavioral.strategy.*;
import behavioral.observer.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Customer input
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        // Step 2: Abstract Factory - Select food and drink
        AbstractFactory foodFactory = FactoryProducer.getFactory("food");
        AbstractFactory drinkFactory = FactoryProducer.getFactory("drink");

        // Food selection
        String foodChoice;
        while (true) {
            System.out.println("Choose food: [burger / pizza]");
            foodChoice = sc.nextLine().toLowerCase();
            if (foodChoice.equals("burger") || foodChoice.equals("pizza")) break;
            System.out.println("Invalid choice. Please enter 'burger' or 'pizza'.");
        }

        // Drink selection
        String drinkChoice;
        while (true) {
            System.out.println("Choose drink: [cola / coffee]");
            drinkChoice = sc.nextLine().toLowerCase();
            if (drinkChoice.equals("cola") || drinkChoice.equals("coffee")) break;
            System.out.println("Invalid choice. Please enter 'cola' or 'coffee'.");
        }

        Product food = foodFactory.getProduct(foodChoice);
        Product drink = drinkFactory.getProduct(drinkChoice);

        // Step 3: Builder - Build order
        Order order = new OrderBuilder()
                .setCustomerName(name)
                .addItem(food.getName(), food.getPrice())
                .addItem(drink.getName(), drink.getPrice())
                .build();

        System.out.println("\nYour order:");
        order.showOrder();

        // Step 4: Strategy - Apply discount
        DiscountContext discountContext = new DiscountContext();
        discountContext.setDiscountStrategy(new PercentageDiscount(10));

        double total = food.getPrice() + drink.getPrice();
        double discountedTotal = discountContext.apply(total);
        System.out.println("Total after discount: " + discountedTotal + " T");

        // Step 5: Bridge - Process payment
        PaymentSystem system = new SimplePaymentSystem();
        PaymentMethod method = new OnlinePayment(system);
        method.pay(discountedTotal);

        // Step 6: Adapter - Print receipt
        NewPrinter printer = new ReceiptAdapter(new OldPrinter());
        printer.print("Receipt - Customer: " + name + ", Total: " + discountedTotal + " T");

        // Step 7: Observer - Notifications
        Restaurant restaurant = new Restaurant();
        Customer mainCustomer = new Customer(name);
        Customer secondCustomer = new Customer("Helper");

        restaurant.addObserver(mainCustomer);
        restaurant.addObserver(secondCustomer);
        System.out.println("\nTwo observers registered.");

        System.out.println("\nNotification Round 1:");
        restaurant.notifyObservers("Your order is being prepared.");

        restaurant.removeObserver(secondCustomer);
        System.out.println("\nHelper removed from observers.");

        System.out.println("Notification Round 2:");
        restaurant.notifyObservers("Your order is ready! Thank you!");

        sc.close();
    }
}