package DecoratorPattern.S3;

public class ConcreteDecoratorA extends  Decorator {
    private String addedState;
    @Override
    public void operation() {
        super.operation();
        this.setAddedState("New State");
        System.out.println("具体装饰对象A的操作");
    }
    public String getAddedState() {
        return addedState;
    }
    public void setAddedState(String addedState) {
        this.addedState = addedState;
    }
}
