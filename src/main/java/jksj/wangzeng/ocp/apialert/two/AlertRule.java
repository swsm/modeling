package jksj.wangzeng.ocp.apialert.two;

import java.util.HashMap;
import java.util.Map;

/**
 * 预警规则枚举
 * @author swsm
 * @date 2020/8/20
 */
public class AlertRule {
    
    private static Map<String, RuleIndex>  ruleIndexMap = new HashMap<>();
    
    {
        ruleIndexMap.put("/api/query", new RuleIndex(10, 10, 10));
        ruleIndexMap.put("/api/insert", new RuleIndex(10, 10, 10));
        ruleIndexMap.put("/api/update", new RuleIndex(10, 10, 10));
        ruleIndexMap.put("/api/delete", new RuleIndex(10, 10, 10));
        
    }
    
    public RuleIndex getMatchedRule(String api) {
        return ruleIndexMap.getOrDefault(api, new RuleIndex(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE));
    }
    
    
    class RuleIndex {
        private int maxTps;
        private int maxErrorCount;
        private int timeoutCount;

        public RuleIndex(int maxTps, int maxErrorCount, int timeoutCount) {
            this.maxTps = maxTps;
            this.maxErrorCount = maxErrorCount;
            this.timeoutCount = timeoutCount;
        }

        public int getMaxTps() {
            return maxTps;
        }


        public int getMaxErrorCount() {
            return maxErrorCount;
        }

        public int getTimeOutCount() {
            return this.timeoutCount;
        }
    }
    
    
}
