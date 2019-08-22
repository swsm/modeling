package study1.behavior.objects.StrategyPattern.S3;

public class CashContext {

    private CashSuper cs;

    public CashContext(CashSuper csuper) {
        this.cs = csuper;
    }

    public double getResult(double money) {
        return cs.acceptCash(money);
    }
}
