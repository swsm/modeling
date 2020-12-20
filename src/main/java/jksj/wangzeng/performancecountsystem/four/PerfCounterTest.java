package jksj.wangzeng.performancecountsystem.four;

/**
 * @author swsm
 * @date 2020/8/23
 */
public class PerfCounterTest {

    public static void main(String[] args) {
        
        ConsoleReporter consoleReporter = new ConsoleReporter();
        consoleReporter.startRepeatedReport(60, 60);

        EmailViewer emailViewer = new EmailViewer();
        emailViewer.addToAddress("123@aa.com");
        EmailReporter emailReporter = new EmailReporter();
        emailReporter.startDailyReport();

        MetricsCollector collector = new MetricsCollector();
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
