package study2.creator.factory.factory1;

public class AimaMotorBycle implements IMotorBycleFactory {
    @Override
    public String getBrand() {
        return "Aima";
    }

    @Override
    public void build() {
        System.out.println(String.format("我的品牌是:{%s},我十分好看！", this.getBrand()));
    }
}
