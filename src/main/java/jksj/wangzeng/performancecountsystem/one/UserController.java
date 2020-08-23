package jksj.wangzeng.performancecountsystem.one;

import java.util.concurrent.TimeUnit;

/**
 * @author swsm
 * @date 2020/8/23
 */
public class UserController {
    
    private Metrics metrics = new Metrics();
    
    public UserController() {
        metrics.startRepeatedReport(60, TimeUnit.SECONDS);
    }
    
    public void register(UserVo user) {
        long startTimeStamp = System.currentTimeMillis();
        metrics.recordTimestamp("register", startTimeStamp);
        
        long respTime = System.currentTimeMillis() - startTimeStamp;
        metrics.recordResponseTime("register", respTime);
    }
    
    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        metrics.recordTimestamp("login", startTimestamp);
        
        long respTime = System.currentTimeMillis() - startTimestamp;
        metrics.recordResponseTime("login", respTime);
        
        return new UserVo();
    }
    
}
