package DecoratorPattern.S3;

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
}
