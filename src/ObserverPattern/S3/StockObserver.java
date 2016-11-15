package ObserverPattern.S3;

public class StockObserver extends Observer {
    public StockObserver(String name, Subject sub) {
        super(name, sub);
    }
    public void update() {
        System.out.println(this.sub.getAction() + this.name + "关闭股票行情，继续工作！");
    }
}
