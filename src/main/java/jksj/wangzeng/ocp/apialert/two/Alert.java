package jksj.wangzeng.ocp.apialert.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 预警类
 * @author swsm
 * @date 2020/8/20
 */
public class Alert {
    
    private List<AbstractAlertHandler> alertHandlerList = new ArrayList<>();
    
    public void addAlertHandler(AbstractAlertHandler alertHandler) {
        this.alertHandlerList.add(alertHandler);
    }
    
    public void check(ApiStatusInfo apiStatusInfo) {
        for (AbstractAlertHandler abstractAlertHandler : alertHandlerList) {
            abstractAlertHandler.check(apiStatusInfo);
        }
    }
    
}
