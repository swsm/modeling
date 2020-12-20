package jksj.wangzeng.performancecountsystem.four;

import java.util.Map;

/**
 * @author swsm
 * @date 2020/8/29
 */
public interface StatViewer {
    
    void output(Map<String, RequestStat> requestStats, long startTimeMillis, long endTimeMillis);
    
}
