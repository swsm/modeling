package study1.creator.SingletonPattern.S3;

/**
 * @author swsm
 * @date 2020/6/9
 */
public class Singleton {
    
    
    private static class SingletonHolder {
        private static Singleton singleton = new Singleton();
    }
    
    private Singleton() {
        
    }
    
    public static Singleton getInstance() {
        return SingletonHolder.singleton;
    }
}
