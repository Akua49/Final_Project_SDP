package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Restaurant implements Subject {
    private List<Observer> customers = new ArrayList<>();

    public void addObserver(Observer o) {
        customers.add(o);
    }

    public void removeObserver(Observer o) {
        customers.remove(o);
    }

    public void notifyObservers(String message) {
        for (Observer c : customers) {
            c.update(message);
        }
    }
}