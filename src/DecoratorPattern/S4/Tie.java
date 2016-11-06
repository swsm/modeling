package DecoratorPattern.S4;

public class Tie extends Finery {
    @Override
    public void show() {
        System.out.print("领带  ");
        super.show();
    }
}
