package study1.constuction.AdapterPattern.S2;

public class Main {

    public static void main(String[] args) {
        Player b = new Forwards("巴蒂尔");
        b.attack();
        Player m = new Guards("麦克格雷迪");
        m.attack();
        Player ym = new Center("姚明");
        ym.attack();
        ym.defense();
    }

}
