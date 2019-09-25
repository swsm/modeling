package study2.creator.factory.factory2;

public class Main {

    public static void main(String[] args) {
        IBycleFactory bycleFactory = new AimaBycleFactory();
        System.out.println(String.format("我创建了一个%s的电动车", bycleFactory.buildBycle().getBrand()));
    }
}
