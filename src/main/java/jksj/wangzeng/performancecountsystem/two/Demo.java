package jksj.wangzeng.performancecountsystem.two;

/**
 * @author swsm
 * @date 2020/8/23
 */
public class Demo {

    public static void main(String[] args) {
        MetricsStorage metricsStorage = new RedisMetricsStorage();
        ConsoleReporter consoleReporter = new ConsoleReporter(metricsStorage);
        consoleReporter.startRepeatedReport(60, 60);
        
        EmailReporter emailReporter = new EmailReporter(metricsStorage);
        emailReporter.addToAddress("123@aa.com");
        emailReporter.startDailyReport();
        
        MetricsCollector collector = new MetricsCollector(metricsStorage);
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("register", 323, 12234));
        collector.recordRequest(new RequestInfo("login", 23, 10234));
        collector.recordRequest(new RequestInfo("login", 123, 14234));
        
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            
        }
    }
    
}
