package jksj.wangzeng.performancecountsystem.four;

import java.util.*;

/**
 * @author swsm
 * @date 2020/8/23
 */
public class Aggregator {
    
    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos, long durationInMillis) {
        Map<String, RequestStat> requestStats = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> requestInfoList = entry.getValue();
            RequestStat requestStat = doAggregate(requestInfoList, durationInMillis);
            requestStats.put(apiName, requestStat);
        }
        return requestStats;
    }
    
    public RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMills) {
        List<Double> respTimes = new ArrayList<>();
        for (RequestInfo requestInfo : requestInfos) {
            double respTime = requestInfo.getResponseTime();
            respTimes.add(respTime);
        }
        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(max(respTimes));
        requestStat.setMinResponseTime(min(respTimes));
        requestStat.setAvgResponseTime(avg(respTimes));
        requestStat.setP999ResponseTime(percentile999(respTimes));
        requestStat.setP99ResponseTime(percentile99(respTimes));
        requestStat.setCount(respTimes.size());
        requestStat.setTps((long)tps(respTimes.size(), durationInMills / 1000));
        return requestStat;
    }

    private double tps(int count, long durationInSeconds) {
        return count / durationInSeconds;
    }


    private double percentile99(List<Double> respTimes) {
        Collections.sort(respTimes);
        int count = respTimes.size();
        int idx99 = (int) (count * 0.99);
        if (count != 0) {
            return respTimes.get(idx99);
        }
        return 0;
    }

    private double percentile999(List<Double> respTimes) {
        Collections.sort(respTimes);
        int count = respTimes.size();
        int idx999 = (int) (count * 0.999);
        if (count != 0) {
            return respTimes.get(idx999);
        }
        return 0;
    }


    private double avg(List<Double> respTimes) {
        double sumRespTimes = 0;
        for (Double respTime : respTimes) {
            sumRespTimes += respTime;
        }
        return sumRespTimes / respTimes.size();
    }

    private double min(List<Double> respTimes) {
        double minRespTime = Double.MAX_VALUE;
        for (Double respTime : respTimes) {
            minRespTime = Math.min(minRespTime, respTime);
        }
        return minRespTime;
    }

    private double max(List<Double> respTimes) {
        double maxRespTime = Double.MIN_VALUE;
        for (Double respTime : respTimes) {
            maxRespTime = Math.max(maxRespTime, respTime);
        }
        return maxRespTime;
    }
    
}
