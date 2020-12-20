package jksj.wangzeng.performancecountsystem.four;

import com.google.gson.Gson;

import java.util.Map;

/**
 * @author swsm
 * @date 2020/8/29
 */
public class ConsoleViewer implements StatViewer {
    
    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeMillis, long endTimeMillis) {
        System.out.println("Time span:[" + startTimeMillis + ", " + endTimeMillis + "]");
        Gson gson = new Gson();
        System.out.println(gson.toJson(requestStats));
    }
    
}
