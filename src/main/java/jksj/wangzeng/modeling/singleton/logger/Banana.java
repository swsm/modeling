package jksj.wangzeng.modeling.singleton.logger;

import java.util.Random;

/**
 * @author swsm
 * @date 2020/8/26
 */
public class Banana {

    public static void main(String[] args) {
        Random random = new Random();
        while (true) {
            new Thread(() -> {
                Logger.getInstance().log("i am a banana ");
                try {
                    Thread.sleep(200 + random.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        

        
    }
    
}
