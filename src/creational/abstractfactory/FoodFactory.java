package creational.abstractfactory;

// Factory for creating food products
public class FoodFactory extends AbstractFactory {
    public Product getProduct(String type) {
        if (type.equalsIgnoreCase("burger")) return new Food("Burger", 2200);
        if (type.equalsIgnoreCase("pizza")) return new Food("Pizza", 4300);
        return null;
    }
}