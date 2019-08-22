package study1.creator.PrototypePattern.S2;

public class ConcretePrototype1 extends Prototype implements Cloneable {

    public ConcretePrototype1(String id) {
        super(id);
    }

    @Override
    public Object clone() {
        Prototype p = null;
        try {
            p = (Prototype)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }

}
