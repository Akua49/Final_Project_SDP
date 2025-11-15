package creational.abstractfactory;

// Factory for creating drink products
public class DrinkFactory extends AbstractFactory {
    public Product getProduct(String type) {
        if (type.equalsIgnoreCase("cola")) return new Drink("Coca-Cola", 500);
        if (type.equalsIgnoreCase("coffee")) return new Drink("Coffee", 1000);
        return null;
    }
}