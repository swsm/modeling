package study1.behavior.objects.ObserverPattern.S1;

public class StockObserver {
    private String name;
    private Secretary sub;
    public StockObserver(String name, Secretary sub) {
        this.name = name;
        this.sub = sub;
    }
    public void update() {
        System.out.println(sub.getAction() + this.name + "关闭股票行情，继续工作！");
    }
}
