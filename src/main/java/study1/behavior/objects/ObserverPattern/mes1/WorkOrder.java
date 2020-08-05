package study1.behavior.objects.ObserverPattern.mes1;

import java.util.Observable;
import java.util.Observer;

public class WorkOrder implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Wip wip = (Wip) o;
        System.out.println("有在制品完成了，生产工单数量加1,完成的在制品批次号为：" + wip.getLotNo());
    }
}
