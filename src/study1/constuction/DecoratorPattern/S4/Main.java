package study1.constuction.DecoratorPattern.S4;

public class Main {
    public static void main(String[] args) {
        Person xc = new Person("小菜");
        System.out.println("\n第一种装扮");
        Sneakers pqx = new Sneakers();
        BigTrouser kk = new BigTrouser();
        TShirts dtx = new TShirts();
        pqx.Decorate(xc);
        kk.Decorate(pqx);
        dtx.Decorate(kk);
        dtx.show();

        System.out.println("第二种装扮");
        LeatherShoes px = new LeatherShoes();
        Tie ld = new Tie();
        Suit xz = new Suit();
        px.Decorate(xc);
        ld.Decorate(px);
        xz.Decorate(ld);
        xz.show();
    }
}
