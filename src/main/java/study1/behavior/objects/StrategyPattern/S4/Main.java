package study1.behavior.objects.StrategyPattern.S4;

public class Main {
    public static void main(String[] args) {
        double total = 0;
        CashContext cc = null;
        cc = new CashContext("满300减100");
        double totalPrices = 0;
        totalPrices = cc.getResult(300);
        total = total + totalPrices;
        System.out.println("结果是: " + total);
    }
}
