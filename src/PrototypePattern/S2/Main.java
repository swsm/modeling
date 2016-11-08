package PrototypePattern.S2;

public class Main {
    public static void main(String[] args) {
        ConcretePrototype1 p1 = new  ConcretePrototype1("I");
        ConcretePrototype1 c1 = (ConcretePrototype1) p1.clone();
        c1.setId("P");
        System.out.println("Cloned: " + c1.getId());
    }
}
