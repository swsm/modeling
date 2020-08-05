package study1.creator.FactoryPattern.S1;

public class OperationDiv extends Operation {
    @Override
    public double getResult() throws Exception {
        if (this.getB() == 0) {
            throw new Exception("除数不能为0");
        }
        double result = 0;
        result = this.getA() / this.getB();
        return result;
    }
}
