package BridgePattern.S1;

public class Abstraction {
    protected Implementor implementor;
    
    public void operation() {
        this.implementor.operation();
    }

    public Implementor getImplementor() {
        return implementor;
    }

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }
    
}
