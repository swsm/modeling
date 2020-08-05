package study1.behavior.objects.StrategyPattern.S1;

public class CashNormal extends CashSuper {

    @Override
    public double acceptCash(double money) {
        return money;
    }

}
