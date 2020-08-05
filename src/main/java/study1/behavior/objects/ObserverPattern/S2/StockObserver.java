package study1.behavior.objects.ObserverPattern.S2;

public class StockObserver extends Observer {
    public StockObserver(String name, Secretary sub) {
        super(name, sub);
    }
    public void update() {
        System.out.println(this.sub.getAction() + this.name + "关闭股票行情，继续工作！");
    }
}
