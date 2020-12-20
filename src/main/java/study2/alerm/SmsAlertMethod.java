package study2.alerm;

import java.util.Arrays;

/**
 * @author swsm
 * @date 2020/11/4
 */
public class SmsAlertMethod implements AlertMethod {
    
    
    @Override
    public void alert(AlertInfo alertInfo) {
        System.out.println(String.format("向手机号=%s的人发送信息标题=%s,发送信息内容=%s",
                Arrays.toString(alertInfo.getTo()), alertInfo.getHead(), alertInfo.getContent()));
    }
    
    
}
