package jksj.wangzeng.modeling.proxy;

/**
 * @author swsm
 * @date 2020/12/19
 */
public class Main {

    public static void main(String[] args) {
        final ITestService testService = (ITestService) DynamicProxyHandler.createProxy(new TestService());
        testService.see();
        testService.look();
    }
}
