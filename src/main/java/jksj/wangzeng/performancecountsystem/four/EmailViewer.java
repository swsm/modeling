package jksj.wangzeng.performancecountsystem.four;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author swsm
 * @date 2020/8/29
 */
public class EmailViewer extends EmailReporter implements StatViewer {
    
    private EmailSender emailSender;
    
    private List<String> toAddress = new ArrayList<>();
    
    public EmailViewer() {
        this.emailSender = new EmailSender();
    }
    
    public EmailViewer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }
    
    public void addToAddress(String address) {
        toAddress.add(address);
    }

    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeMillis, long endTimeMillis) {
        // format the requestStats to HTML style. 
        // send it to email toAddresses.
    }
}
