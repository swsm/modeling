package StrategyPattern.S4;

public class CashFactory {
    
    public static CashSuper createCashAccept(String type) {
        CashSuper cs = null;
        if ("正常收费".equals(type)) {
            cs = new CashNormal();
        } else if ("满300返100".equals(type)) {
            CashReturn cr1 = new CashReturn("300", "100");
            cs = cr1;
        } else if ("打8折".equals(type)) {
            CashRebate cr2 = new CashRebate("0.8");
            cs = cr2;
        } 
        return cs;
    }
}
