package study1.constuction.DecoratorPattern.S4;

public class Sneakers extends Finery {
    @Override
    public void show() {
        System.out.print("夹克  ");
        super.show();
    }
}
