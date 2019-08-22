package study1.behavior.objects.ObserverPattern.S2;

public class NBAObserver extends Observer {
    public NBAObserver(String name, Secretary sub) {
        super(name, sub);
    }
    public void update() {
        System.out.println(this.sub.getAction() + this.name + "关闭NBA直播，继续工作！");
    }
}
