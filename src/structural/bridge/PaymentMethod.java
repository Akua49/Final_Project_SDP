package structural.bridge;

// Abstraction
public abstract class PaymentMethod {
    protected PaymentSystem system;

    public PaymentMethod(PaymentSystem system) {
        this.system = system;
    }

    public abstract void pay(double amount);
}