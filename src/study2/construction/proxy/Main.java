package study2.construction.proxy;

public class Main {

    public static void main(String[] args) {
        HouseProxy houseManager = new HouseProxy();
        houseManager.register(new Customer("zhangsan"));
        System.out.println(String.format("喜欢房子的人是:%s", houseManager.getRegister().getName()));
    }
}
