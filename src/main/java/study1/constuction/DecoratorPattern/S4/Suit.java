package study1.constuction.DecoratorPattern.S4;

public class Suit extends Finery {
    @Override
    public void show() {
        System.out.print("西服  ");
        super.show();
    }
}
