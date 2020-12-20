package study2.alerm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author swsm
 * @date 2020/11/4
 */
public class CommonAlertHandler implements IAlertHandler {
    
    private Map<String, CurrentAlertInfo> currentApiStatus = new ConcurrentHashMap<>();

    /**
     * api 信息
     */
    private static Map<String, List<AlertTarget>> apiMap = new HashMap<>();
    
    static {
        apiMap.put("get:/getName", Arrays.asList(
                new AlertTarget(3, 8, 1, new SmsAlertMethod())
                ,
                new AlertTarget(3, 10, 2, new EmailAlertMethod())
              ));
        apiMap.put("post:/updateName", Arrays.asList(
                new AlertTarget(4, 30, 1, new SmsAlertMethod()),
                new AlertTarget(4, 35, 2, new EmailAlertMethod())
        ));
    }
    

    private String buildCurrentApiStatus(String apiSign, int type) {
        return apiSign + ":" + type;
    }
    
    

    @Override
    public void handle(String apiSign, int type, long time) {
        String currentApiSign = buildCurrentApiStatus(apiSign, type);
        if (apiMap.containsKey(apiSign)) {
            List<AlertTarget> alertTargets = apiMap.get(apiSign);
            alertTargets.forEach(alertTarget -> {
                if (type == alertTarget.getType()) {
                    CurrentAlertInfo currentAlertInfo = currentApiStatus.get(currentApiSign);
                    if (currentAlertInfo == null) {
                        synchronized (this) {
                            currentAlertInfo = currentApiStatus.get(currentApiSign);
                            if (currentAlertInfo == null) {
                                currentAlertInfo = new CurrentAlertInfo(time);
                                checkToAlert(currentApiSign, currentAlertInfo, alertTarget, apiSign, type);
                                return;
                            }
                        }
                    }

                    if ((time - currentAlertInfo.getTime()) / 1000 > alertTarget.getSeconds()) {
                        synchronized (currentAlertInfo) {
                            currentAlertInfo = currentApiStatus.get(currentApiSign);
                            if ((time - currentAlertInfo.getTime()) / 1000 > alertTarget.getSeconds()) {
                                currentAlertInfo = new CurrentAlertInfo(currentAlertInfo.getTime() + (time - currentAlertInfo.getTime()) / alertTarget.getSeconds() * alertTarget.getSeconds());
                                checkToAlert(currentApiSign, currentAlertInfo, alertTarget, apiSign, type);
                                return;
                            }
                        }
                        
                    }
                    
                    checkToAlert(currentApiSign, currentAlertInfo, alertTarget, apiSign, type);
                    
                }
            });
            
        }
    }
    
    private void checkToAlert(String currentApiSign, CurrentAlertInfo oldAlertInfo, AlertTarget alertTarget, String apiSign, int type) {
        oldAlertInfo.count.incrementAndGet();
        currentApiStatus.put(currentApiSign, oldAlertInfo);
        if (oldAlertInfo.count.get() >= alertTarget.getCount()) {
            String content = String.format("接口描述=%s,错误类型=%d,在%d秒内已经出现%d此失败,配置的次数=%d,请尽快查看处理", apiSign, type,
                    alertTarget.getSeconds(), oldAlertInfo.getCount().get(), alertTarget.getCount());
            String head = String.format("接口描述=%s,错误类型=%d", apiSign, type);
            String[] to = {"zhangsan", "lisi"};
            alertTarget.getAlertMethod().alert(new AlertInfo(content, head, to));
        }
    }
    
    class CurrentAlertInfo {
        private long time;
        private AtomicInteger count;
        
        public CurrentAlertInfo(long time) {
            this.time = time;
            count = new AtomicInteger(0);
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public AtomicInteger getCount() {
            return count;
        }

        public void setCount(AtomicInteger count) {
            this.count = count;
        }
    }
}
