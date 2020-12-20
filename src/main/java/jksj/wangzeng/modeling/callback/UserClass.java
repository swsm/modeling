package jksj.wangzeng.modeling.callback;

/**
 * @author swsm
 * @date 2020/12/20
 */
public class UserClass {
    
    @FunctionalInterface
    interface Icallback {
        void callBack();
    }
    
    public void testCallBack(Icallback callback) {
        System.out.println("我开始执行我的方法了");
        callback.callBack();
        System.out.println("我执行完我的方法了");
    }

    public static void main(String[] args) {
        UserClass userClass = new UserClass();
        userClass.testCallBack(() -> {
            System.out.println("我被回调啦啦啦啦");
        });
    }
}
