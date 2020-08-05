package study1.creator.FactoryPattern.S2;

public class SubFactory implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationSub();
    }

}
