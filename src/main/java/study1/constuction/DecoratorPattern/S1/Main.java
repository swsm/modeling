package study1.constuction.DecoratorPattern.S1;

public class Main {

    public static void main(String[] args) {
        Person xc = new Person("小菜");
        System.out.println("小菜的第一种装扮: ");
        xc.wareTshirts();
        xc.wareBigTrouser();
        xc.wareSneakers();
        xc.show();

        System.out.println("小菜的第二种装扮: ");
        xc.wareSuit();
        xc.wareTie();
        xc.wareLeatherShoes();
        xc.show();
    }

}
