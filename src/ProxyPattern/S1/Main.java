package ProxyPattern.S1;

public class Main {
    public static void main(String[] args) {
        SchoolGirl jiaojiao  = new SchoolGirl();
        jiaojiao.setName("李娇娇");
        Pursuit zhuojiayi = new Pursuit(jiaojiao);
        zhuojiayi.giveDolls();
        zhuojiayi.giveFlowers();
        zhuojiayi.giveChocolate();
    }
}
