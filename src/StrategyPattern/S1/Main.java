package StrategyPattern.S1;

public class Main {

    public static void main(String[] args) {
        double total = 0;
        CashSuper csuper = CashFactory.createCashAccept("打8折");
        double totalPrices = 0;
        totalPrices = csuper.acceptCash(456) * 1;
        total = total + totalPrices;
        System.out.println("结算:" + total);
    }

}
