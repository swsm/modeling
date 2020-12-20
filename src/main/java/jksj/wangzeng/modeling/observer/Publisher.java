package jksj.wangzeng.modeling.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author swsm
 * @date 2020/12/20
 */
public class Publisher implements Observer {
    
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("我收到了对象" + o.toString() + "的信息=" + arg.toString());
    }
}
