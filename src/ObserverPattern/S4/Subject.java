package ObserverPattern.S4;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    public void attach(Observer observer) {
        this.observers.add(observer);
    }
    public void detach(Observer observer) {
        this.observers.remove(observer);
    }
    public void myNotify() {
        for (Observer o : this.observers) {
            o.update();
        }
    }
}
