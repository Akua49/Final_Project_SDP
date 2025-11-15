package creational.abstractfactory;

// Factory producer to get specific factories
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("food")) return new FoodFactory();
        if (choice.equalsIgnoreCase("drink")) return new DrinkFactory();
        return null;
    }
}