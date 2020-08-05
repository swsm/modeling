package study1.creator.FactoryPattern.S2;

public class AddFactory implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }

}
