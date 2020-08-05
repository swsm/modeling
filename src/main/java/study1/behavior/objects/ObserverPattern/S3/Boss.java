package study1.behavior.objects.ObserverPattern.S3;

import java.util.ArrayList;
import java.util.List;

public class Boss implements Subject {

    private List<Observer> observers = new ArrayList<Observer>();
    private String action;

    @Override
    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void myNotify() {
        for (Observer o : this.observers) {
            o.update();
        }
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}
