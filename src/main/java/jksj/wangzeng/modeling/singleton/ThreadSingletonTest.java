package jksj.wangzeng.modeling.singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * @author swsm
 * @date 2020/12/19
 */
public class ThreadSingletonTest {

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            threadList.add(new Thread(() -> {
                ThreadSingleton instance = ThreadSingleton.getInstance();
                System.out.println(Thread.currentThread().getName() + "  " + instance);

                instance.remove();

                System.out.println(Thread.currentThread().getName() + "  " + instance);
                System.out.println(Thread.currentThread().getName() + "  " + ThreadSingleton.getInstance());
                
            }));
        }
        for (Thread thread : threadList) {
            thread.start();
        }
    }

}
