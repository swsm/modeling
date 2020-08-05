package study1.creator.SingletonPattern.serialtest;

import java.io.Serializable;

/**
 * @author swsm
 * @date 2020/6/9
 */
public class TestClass implements Serializable {

    private String name;
    private int age;
    
    public TestClass(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
