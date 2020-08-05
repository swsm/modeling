package study1.behavior.objects.ObserverPattern.mes1;

public class Main {

    public static void main(String[] args) {
        Wip wip = new Wip("最帅在制品1");
        wip.addObserver(new WorkOrder());
        wip.addObserver(new WorkBatch());
        wip.setStatus("进行中");
        wip.setStatus("已完成");
        wip.setStatus("已自检");
        wip.setStatus("已质检");
        wip.setStatus("已转出");
        wip.setStatus("已使用");
    }
}
