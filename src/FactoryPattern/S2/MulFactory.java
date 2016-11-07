package FactoryPattern.S2;

public class MulFactory implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationMul();
    }

}
