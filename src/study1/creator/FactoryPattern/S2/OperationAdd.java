package study1.creator.FactoryPattern.S2;

public class OperationAdd extends Operation {

    @Override
    public double getResult() {
        double result = 0;
        result = this.getA() + this.getB();
        return result;
    }
}
