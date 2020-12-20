package jksj.wangzeng.performancecountsystem.four;

/**
 * @author swsm
 * @date 2020/8/23
 */
public class Demo {

    public static void main(String[] args) {
        MetricsStorage metricsStorage = new RedisMetricsStorage();
        
        ConsoleReporter consoleReporter = new ConsoleReporter(metricsStorage, new Aggregator(), new ConsoleViewer());
        consoleReporter.startRepeatedReport(60, 60);

        EmailViewer emailViewer = new EmailViewer();
        emailViewer.addToAddress("123@aa.com");
        EmailReporter emailReporter = new EmailReporter(metricsStorage, new Aggregator(), emailViewer);
        emailReporter.startDailyReport();

        MetricsCollector collector = new MetricsCollector(metricsStorage, 10);
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

//    public static void main(String[] args) {
//        String hello = "hello";
//        String hello1 = "hello";
//        String hello2 = new String("hello");
//
//        System.out.println(hello + hello.hashCode());
//        System.out.println(hello1 + hello.hashCode());
//        System.out.println(hello2 + hello.hashCode());
//    }
    
}
