package study1.behavior.objects.VisitorPattern.S2;

public class Main {

    public static void main(String[] args) {
        ObjectStruture o = new ObjectStruture();
        o.attach(new ConcreteElementA());
        o.attach(new ConcreteElementB());

        ConcreteVisitor1 v1 = new ConcreteVisitor1();
        ConcreteVisitor2 v2 = new ConcreteVisitor2();

        o.accept(v1);
        o.accept(v2);
    }

}
