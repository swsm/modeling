package study1.constuction.DecoratorPattern.S3;

public class ConcreteDecoratorB extends  Decorator {
    private String addedState;
    @Override
    public void operation() {
        super.operation();
        this.addedBehavior();
        System.out.println("具体装饰对象B的操作");
    }

    public void addedBehavior() {

    }

    public String getAddedState() {
        return addedState;
    }

    public void setAddedState(String addedState) {
        this.addedState = addedState;
    }
}
