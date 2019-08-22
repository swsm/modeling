package study1.constuction.DecoratorPattern.S4;

public class LeatherShoes extends Finery {
    @Override
    public void show() {
        System.out.print("皮鞋  ");
        super.show();
    }
}
