package study1.behavior.objects.StrategyPattern.S4;

public class CashContext {

    private CashSuper cs;

    public CashContext(String type) {
        if ("正常收费".equals(type)) {
            cs = new CashNormal();
        } else if ("打八折".equals(type)) {
            cs = new CashRebate("0.8");
        } else if ("满300减100".equals(type)) {
            cs = new CashReturn("300", "100");
        }
    }

    public double getResult(double money) {
        return cs.acceptCash(money);
    }
}
