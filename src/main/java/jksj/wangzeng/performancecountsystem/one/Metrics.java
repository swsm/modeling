package jksj.wangzeng.performancecountsystem.one;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 最小原型的方式实现 接口调用性能统计框架
 * @author swsm
 * @date 2020/8/23
 */
public class Metrics {
    
    private Map<String, List<Double>> responseTimes = new HashMap<>();
    private Map<String, List<Double>> timestamps = new HashMap<>();
    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    
    public void recordResponseTime(String apiName, double responseTime) {
        responseTimes.put(apiName, new ArrayList<>());
        responseTimes.get(apiName).add(responseTime);
    }
    
    public void recordTimestamp(String apiName, double timestamp) {
        timestamps.put(apiName, new ArrayList<>());
        timestamps.get(apiName).add(timestamp);
    }
    
    public void startRepeatedReport(long period, TimeUnit unit) {
        executorService.scheduleAtFixedRate(() -> {
            Gson gson = new Gson();
            Map<String, Map<String, Double>> stats = new HashMap<>();
            for (Map.Entry<String, List<Double>> entry : responseTimes.entrySet()) {
                String apiName = entry.getKey();
                List<Double> apiRespTimes = entry.getValue();
                stats.putIfAbsent(apiName, new HashMap<>());
                stats.get(apiName).put("max", max(apiRespTimes));
                stats.get(apiName).put("avg", avg(apiRespTimes));
            }
            
            for (Map.Entry<String, List<Double>> entry : timestamps.entrySet()) {
                String apiName = entry.getKey();
                List<Double> apiTimestamps = entry.getValue();
                stats.putIfAbsent(apiName, new HashMap<>());
                stats.get(apiName).put("count", (double) apiTimestamps.size());
            }

            System.out.println(gson.toJson(stats));
        }, 30, period, unit);
    }
    
    private double max(List<Double> dataset) {
        double max = dataset.get(0);
        for (int i = 1; i < dataset.size(); i++) {
            max = Math.max(max, dataset.get(i));
        }
        return max;
    }
    
    private double avg(List<Double> dataset) {
        double sum = 0;
        for (Double d : dataset) {
            sum += d;
        }
        return sum / dataset.size();
    }
    
}
