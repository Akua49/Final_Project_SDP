package behavioral.strategy;

public class DiscountContext {
    private DiscountStrategy discountStrategy = new NoDiscount();

    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    public double apply(double total) {
        return discountStrategy.applyDiscount(total);
    }
}