package study1.creator.FactoryPattern.S2;

public class DivFactory implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationDiv();
    }

}
