package jksj.wangzeng.modeling.proxy;

/**
 * @author swsm
 * @date 2020/12/19
 */
public class TestService implements ITestService {
    
    @Override
    public void see() {
        System.out.println("我想去看看");
    }

    @Override
    public void look() {
        System.out.println("我想瞧一瞧");
    }
}
