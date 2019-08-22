package study1.creator.FactoryPattern.S2;

public class MulFactory implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationMul();
    }

}
