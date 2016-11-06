package DecoratorPattern.S2;

public class Main {

    public static void main(String[] args) {
        Person xc = new Person("小菜");
        System.out.println("小菜的第一种装扮: ");
        Finery dtx = new TShirts();
        Finery kk = new BigTrouser();
        Finery pqx = new Sneakers();
        dtx.show();
        kk.show();
        pqx.show();
        xc.show();
        
        System.out.println("小菜的第二种装扮: ");
        Finery xz = new Suit();
        Finery ld = new Tie();
        Finery px = new LeatherShoes();
        xc.show();
    }

}
