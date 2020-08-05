package study1.creator.SingletonPattern.S2;

/**
 * 双重锁定单例方法
 */
public class Singleton {
    volatile private static Singleton instance;
    private Singleton() {

    }
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if(instance == null){//二次检查
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
