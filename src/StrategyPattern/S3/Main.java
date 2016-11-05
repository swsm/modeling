package StrategyPattern.S3;

public class Main {
    public static void main(String[] args) {
        double total = 0;
        CashContext cc = null;
        if ("正常收费".equals(args[0])) {
            cc = new CashContext(new CashNormal());
        } else if ("打八折".equals(args[0])) {
            cc = new CashContext(new CashRebate("0.8"));
        } else if ("满300减100".equals(args[0])) {
            cc = new CashContext(new CashReturn("300", "100"));
        }
        double totalPrices = 0;
        totalPrices = cc.getResult(300);
        total = total + totalPrices;
        System.out.println("结果是: " + total);
    }
}
