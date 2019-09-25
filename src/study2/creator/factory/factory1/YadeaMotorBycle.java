package study2.creator.factory.factory1;

public class YadeaMotorBycle implements IMotorBycleFactory {
    @Override
    public String getBrand() {
        return "Yadea";
    }

    @Override
    public void build() {
        System.out.println(String.format("我的品牌是:{%s},我的续航能力很好！", this.getBrand()));
    }
}
