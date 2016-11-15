package ObserverPattern.S1;

import java.util.ArrayList;
import java.util.List;

public class Secretary {
    private List<StockObserver> observers = new ArrayList<StockObserver>();
    private String action;
    public void attach(StockObserver observer) {
        this.observers.add(observer);
    }
    public void myNotify() {
        for (StockObserver o : this.observers) {
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
