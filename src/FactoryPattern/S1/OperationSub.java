package FactoryPattern.S1;

public class OperationSub extends Operation {
    
    @Override
    public double getResult() {
        double result = 0;
        result = this.getA() - this.getB();
        return result;
    }
}
