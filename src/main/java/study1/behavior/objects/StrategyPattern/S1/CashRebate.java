package study1.behavior.objects.StrategyPattern.S1;

public class CashRebate extends CashSuper {

    private double monthRebate = 1.0;

    public CashRebate(String montyRebate) {
        this.monthRebate = Double.parseDouble(montyRebate);
    }

    @Override
    public double acceptCash(double money) {
        return money * this.monthRebate;
    }

}
