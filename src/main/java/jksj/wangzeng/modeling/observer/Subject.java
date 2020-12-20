package jksj.wangzeng.modeling.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author swsm
 * @date 2020/12/20
 */
public class Subject extends Observable {
    
    private List<Observer> observerList = new ArrayList<>();
    
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }
    
    public void deleteObserver(Observer observer) {
        observerList.remove(observer);
    }


    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(this, "我被修改了");
        }
    }
}
