package study1.creator.SingletonPattern.serialtest;

import java.io.Serializable;
import java.util.List;

/**
 * @author swsm
 * @date 2020/6/9
 */
public class TestListSerializable implements Serializable {
    
    private int a;
    private String b;
    private String[] arr;
    private List<String> pp;
    private TestClass testClass;
    


    public TestListSerializable(int a, String b, String[] arr, List<String> pp, TestClass testClass) {
        this.a = a;
        this.b = b;
        this.arr = arr;
        this.pp = pp;
        this.testClass = testClass;
    }
    
}
