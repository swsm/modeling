package study1.behavior.objects.ObserverPattern.S3;

public class Main {

    public static void main(String[] args) {
        Boss huhansan = new Boss();
        StockObserver tongshi1 = new StockObserver("魏关姹", huhansan);
        NBAObserver tongshi2 = new NBAObserver("易管查", huhansan);
        huhansan.attach(tongshi1);
        huhansan.attach(tongshi2);

        huhansan.detach(tongshi1);

        huhansan.setAction("我胡汉三回来了！");
        huhansan.myNotify();

    }

}
