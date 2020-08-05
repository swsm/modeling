package study1.behavior.objects.VisitorPattern.S2;

public class ConcreteElementA extends Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementA(this);
    }

    public void operationA(){}

}
