# UML Diagrams
## 1) All Patterns Included

```mermaid
classDiagram
    direction TB
    
    %% ========== CREATIONAL PATTERNS ==========
    note for OrderBuilder "Builder Pattern\nStep-by-step order creation"
    class OrderBuilder {
        -customerName: String
        -items: List~String~
        -totalPrice: double
        +setCustomerName(String) OrderBuilder
        +addItem(String, double) OrderBuilder
        +build() Order
    }
    
    class Order {
        -customerName: String
        -items: List~String~
        -totalPrice: double
        +Order(String, List~String~, double)
        +showOrder() void
    }
    
    note for AbstractFactory "Abstract Factory Pattern\nCreate product families"
    class AbstractFactory {
        <<abstract>>
        +getProduct(String) Product
    }
    
    class FoodFactory {
        +getProduct(String) Product
    }
    
    class DrinkFactory {
        +getProduct(String) Product
    }
    
    class FactoryProducer {
        +getFactory(String) AbstractFactory
    }
    
    class Product {
        <<interface>>
        +getName() String
        +getPrice() double
    }
    
    class Food {
        -name: String
        -price: double
        +Food(String, double)
        +getName() String
        +getPrice() double
    }
    
    class Drink {
        -name: String
        -price: double
        +Drink(String, double)
        +getName() String
        +getPrice() double
    }
    
    %% ========== STRUCTURAL PATTERNS ==========
    note for PaymentMethod "Bridge Pattern\nSeparate payment abstraction from implementation"
    class PaymentMethod {
        <<abstract>>
        #system: PaymentSystem
        +PaymentMethod(PaymentSystem)
        +pay(double) void
    }
    
    class CashPayment {
        +CashPayment(PaymentSystem)
        +pay(double) void
    }
    
    class OnlinePayment {
        +OnlinePayment(PaymentSystem)
        +pay(double) void
    }
    
    class PaymentSystem {
        <<interface>>
        +processPayment(String, double) void
    }
    
    class SimplePaymentSystem {
        +processPayment(String, double) void
    }
    
    note for ReceiptAdapter "Adapter Pattern\nAdapt old printer to new interface"
    class OldPrinter {
        +printOld(String) void
    }
    
    class NewPrinter {
        <<interface>>
        +print(String) void
    }
    
    class ReceiptAdapter {
        -oldPrinter: OldPrinter
        +ReceiptAdapter(OldPrinter)
        +print(String) void
    }
    
    %% ========== BEHAVIORAL PATTERNS ==========
    note for DiscountContext "Strategy Pattern\nInterchangeable discount algorithms"
    class DiscountStrategy {
        <<interface>>
        +applyDiscount(double) double
    }
    
    class NoDiscount {
        +applyDiscount(double) double
    }
    
    class PercentageDiscount {
        -percent: double
        +PercentageDiscount(double)
        +applyDiscount(double) double
    }
    
    class FixedDiscount {
        -amount: double
        +FixedDiscount(double)
        +applyDiscount(double) double
    }
    
    class DiscountContext {
        -discountStrategy: DiscountStrategy
        +setDiscountStrategy(DiscountStrategy) void
        +apply(double) double
    }
    
    note for Restaurant "Observer Pattern\nNotify customers of order status"
    class Observer {
        <<interface>>
        +update(String) void
    }
    
    class Subject {
        <<interface>>
        +addObserver(Observer) void
        +removeObserver(Observer) void
        +notifyObservers(String) void
    }
    
    class Customer {
        -name: String
        +Customer(String)
        +update(String) void
    }
    
    class Restaurant {
        -customers: List~Observer~
        +addObserver(Observer) void
        +removeObserver(Observer) void
        +notifyObservers(String) void
    }
    
    %% ========== RELATIONSHIPS ==========
    %% Builder
    OrderBuilder --> Order : builds
    
    %% Abstract Factory
    AbstractFactory <|-- FoodFactory
    AbstractFactory <|-- DrinkFactory
    FoodFactory --> Food : creates
    DrinkFactory --> Drink : creates
    Product <|.. Food : implements
    Product <|.. Drink : implements
    FactoryProducer --> AbstractFactory : produces
    
    %% Bridge
    PaymentMethod <|-- CashPayment
    PaymentMethod <|-- OnlinePayment
    PaymentMethod --> PaymentSystem : uses
    PaymentSystem <|.. SimplePaymentSystem : implements
    
    %% Adapter
    NewPrinter <|.. ReceiptAdapter : implements
    ReceiptAdapter --> OldPrinter : adapts
    
    %% Strategy
    DiscountStrategy <|.. NoDiscount : implements
    DiscountStrategy <|.. PercentageDiscount : implements
    DiscountStrategy <|.. FixedDiscount : implements
    DiscountContext --> DiscountStrategy : uses
    
    %% Observer
    Subject <|.. Restaurant : implements
    Observer <|.. Customer : implements
    Restaurant --> Observer : notifies
```
