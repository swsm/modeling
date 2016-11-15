package ObserverPattern.S1;

public class Main {

    public static void main(String[] args) {
        Secretary tongzizhe = new Secretary();
        StockObserver tongshi1 = new StockObserver("魏关姹", tongzizhe);
        StockObserver tongshi2 = new StockObserver("易管查", tongzizhe);
        
        tongzizhe.attach(tongshi1);
        tongzizhe.attach(tongshi2);
        
        tongzizhe.setAction("老板回来了!");
        tongzizhe.myNotify();
    }

}
