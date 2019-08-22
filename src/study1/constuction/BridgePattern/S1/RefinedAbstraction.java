package study1.constuction.BridgePattern.S1;

public class RefinedAbstraction extends Abstraction {
    @Override
    public void operation() {
        this.implementor.operation();
    }
}
