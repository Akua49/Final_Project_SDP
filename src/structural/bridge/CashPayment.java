package structural.bridge;

// Refined abstraction - Cash payment
public class CashPayment extends PaymentMethod {
    public CashPayment(PaymentSystem system) {
        super(system);
    }

    public void pay(double amount) {
        system.processPayment("Cash", amount);
    }
}