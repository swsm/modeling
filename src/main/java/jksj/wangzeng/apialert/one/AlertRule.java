package jksj.wangzeng.apialert.one;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 预警规则枚举
 * @author swsm
 * @date 2020/8/20
 */
public class AlertRule {
    
    private static Map<String, RuleIndex>  ruleIndexMap = new ConcurrentHashMap<>();
    
    {
        ruleIndexMap.put("/api/query", new RuleIndex(10, 10));
        ruleIndexMap.put("/api/insert", new RuleIndex(10, 10));
        ruleIndexMap.put("/api/update", new RuleIndex(10, 10));
        ruleIndexMap.put("/api/delete", new RuleIndex(10, 10));
        
    }
    
    public RuleIndex getMatchedRule(String api) {
        return ruleIndexMap.getOrDefault(api, new RuleIndex(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }
    
    
    class RuleIndex {
        private int maxTps;
        private int maxErrorCount;

        public RuleIndex(int maxTps, int maxErrorCount) {
            this.maxTps = maxTps;
            this.maxErrorCount = maxErrorCount;
        }

        public int getMaxTps() {
            return maxTps;
        }

        public void setMaxTps(int maxTps) {
            this.maxTps = maxTps;
        }

        public int getMaxErrorCount() {
            return maxErrorCount;
        }

        public void setMaxErrorCount(int maxErrorCount) {
            this.maxErrorCount = maxErrorCount;
        }
    }
    
    
}
