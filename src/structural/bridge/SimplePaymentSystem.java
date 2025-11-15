package structural.bridge;

// Concrete implementation
public class SimplePaymentSystem implements PaymentSystem {
    public void processPayment(String method, double amount) {
        System.out.println("Payment of " + amount + " T via " + method + " processed successfully!");
    }
}