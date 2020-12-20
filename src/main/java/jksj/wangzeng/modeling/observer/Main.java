package jksj.wangzeng.modeling.observer;

/**
 * @author swsm
 * @date 2020/12/20
 */
public class Main {

    public static void main(String[] args) {
        Publisher publisher1 = new Publisher();
        Publisher publisher2 = new Publisher();
        
        Subject subject = new Subject();
        subject.addObserver(publisher1);
        subject.addObserver(publisher2);
        
        subject.notifyObservers();
    }
    
}
