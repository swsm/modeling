package jksj.wangzeng.testunit.example.one;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

/**
 * @author swsm
 * @date 2020/8/26
 */
public class TestDemoRestructure {
    
    @Test
    public void testCaculateDelayDays() {
        Calendar instance = Calendar.getInstance();
        long currentTimeMillis = instance.getTimeInMillis();
        DemoRestructure demo = new DemoRestructure() {
           protected long getCurrentTimeMillis() {
               return currentTimeMillis;
           } 
        };
        instance.add(Calendar.DATE, -2);
        long res = demo.caculateDelayDays(instance.getTime());
        Assert.assertEquals(2, res);
        
    }
    
}
