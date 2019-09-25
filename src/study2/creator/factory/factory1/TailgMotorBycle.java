package study2.creator.factory.factory1;

public class TailgMotorBycle implements IMotorBycleFactory {
    @Override
    public String getBrand() {
        return "Tailg";
    }

    @Override
    public void build() {
        System.out.println(String.format("我的品牌是:{%s},我的质量很好！", this.getBrand()));
    }
}
