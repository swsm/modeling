package study2.alerm;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author swsm
 * @date 2020/11/4
 */
public class Application {

    public static void main(String[] args) {
        String[] apis = {"get:/getName", "post:/updateName"};
        int[] types = {1, 2};
        IAlertHandler alertHandler = new CommonAlertHandler();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0, 5).forEach(i -> {
            executorService.execute(() -> {
                while (true) {
                    int sleepMillSeconds = (new Random().nextInt(2)) * 1000;
                    int apiIndex = new Random().nextInt(2);
                    int typeIndex = new Random().nextInt(2);
                    try {
                        Thread.sleep(sleepMillSeconds);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "说:" + apis[apiIndex] + "的接口" + "出现类型" + types[typeIndex] +"的异常");
                    alertHandler.handle(apis[apiIndex], types[typeIndex], new Date().getTime());
                }
            });
        });
        
    }
    
}
