package jksj.wangzeng.modeling.singleton;

import java.util.UUID;

/**
 * @author swsm
 * @date 2020/12/19
 */
public class ThreadSingleton {
    
    private String name;
    
    private static ThreadLocal<ThreadSingleton> threadSingletonThreadLocal = ThreadLocal.withInitial(() -> new ThreadSingleton(UUID.randomUUID().toString()));
    
    private ThreadSingleton(String name) {
        this.name = name;
    } 
    
    public static ThreadSingleton getInstance() {
        return threadSingletonThreadLocal.get();
    }
    
    public void remove() {
        threadSingletonThreadLocal.remove();
    }

    @Override
    public String toString() {
        return "ThreadSingleton{" +
                "name='" + name + '\'' +
                '}';
    }
}
