package study1.behavior.objects.StrategyPattern.S3;

public class CashNormal extends CashSuper {

    @Override
    public double acceptCash(double money) {
        return money;
    }

}
