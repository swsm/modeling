package study2.creator.factory.factory1;

public class Main {

    public static void main(String[] args) {
        IMotorBycleFactory motorBycleFactory1 = new AimaMotorBycle();
        motorBycleFactory1.build();
        IMotorBycleFactory motorBycleFactory2 = new YadeaMotorBycle();
        motorBycleFactory2.build();
        IMotorBycleFactory motorBycleFactory3 = new TailgMotorBycle();
        motorBycleFactory3.build();
    }
}
