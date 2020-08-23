package jksj.wangzeng.performancecountsystem.two;

import java.util.*;

/**
 * @author swsm
 * @date 2020/8/23
 */
public class EmailReporter {
    
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;
    
    private MetricsStorage metricsStorage;
    private EmailSender emailSender;
    private List<String> toAddress = new ArrayList<>();
    
    public EmailReporter(MetricsStorage metricsStorage) {
        this(metricsStorage, new EmailSender());
    }
    
    public EmailReporter(MetricsStorage metricsStorage, EmailSender emailSender) {
        this.metricsStorage = metricsStorage;
        this.emailSender = emailSender;
    }
    
    public void addToAddress(String address) {
        toAddress.add(address);
    }
    
    public void startDailyReport() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date firstTime = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMills = System.currentTimeMillis();
                long startTimeInMills = endTimeInMills - durationInMillis;
                Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMills, endTimeInMills);
                Map<String, RequestStat> stats = new HashMap<>();
                for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
                    String apiName = entry.getKey();
                    List<RequestInfo> requestInfosPerApi = entry.getValue();
                    RequestStat requestStat = Aggregator.aggregate(requestInfosPerApi, durationInMillis);
                    stats.put(apiName, requestStat);
                }
                // todo 格式化为html格式，并且发送邮件
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }
    
}
