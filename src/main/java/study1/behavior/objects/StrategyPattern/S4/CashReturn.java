package study1.behavior.objects.StrategyPattern.S4;

public class CashReturn extends CashSuper {

    private double moneyCondition = 0.0;
    private double moneyReturn = 0.0;

    public CashReturn(String moneyCondition, String moneyReturn) {
        this.moneyCondition = Double.parseDouble(moneyCondition);
        this.moneyReturn = Double.parseDouble(moneyReturn);
    }

    @Override
    public double acceptCash(double money) {
        double result = money;
        if (money >= this.moneyCondition) {
            result = money - Math.floor(money / this.moneyCondition) * this.moneyReturn;
        }
        return result;
    }

}
