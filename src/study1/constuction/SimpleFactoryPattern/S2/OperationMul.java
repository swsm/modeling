package study1.constuction.SimpleFactoryPattern.S2;

public class OperationMul extends Operation {

    @Override
    public double getResult() {
        double result = 0;
        result = this.getA() * this.getB();
        return result;
    }
}
