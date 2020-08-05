package study1.creator.SingletonPattern.serialtest;

import org.apache.commons.lang3.SerializationUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author swsm
 * @date 2020/6/9
 */
public class TestListSerializableMain {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cc");
        list.add("dd");
        TestListSerializable testListSerializable = new TestListSerializable(1, "2", new String[]{"aa", "bb"}, list, new TestClass("123", 1));
        byte[] serialize = SerializationUtils.serialize(testListSerializable);
        TestListSerializable newInstance = SerializationUtils.deserialize(serialize);
        System.out.println(testListSerializable == newInstance);
    }
    
}
