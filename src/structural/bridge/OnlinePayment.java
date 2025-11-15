package structural.bridge;

// Refined abstraction - Online payment
public class OnlinePayment extends PaymentMethod {
    public OnlinePayment(PaymentSystem system) {
        super(system);
    }

    public void pay(double amount) {
        system.processPayment("Online", amount);
    }
}