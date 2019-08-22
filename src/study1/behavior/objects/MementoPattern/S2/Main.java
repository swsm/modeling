package study1.behavior.objects.MementoPattern.S2;

public class Main {

    public static void main(String[] args) {
        Originator o = new Originator();
        o.setState("On");
        o.show();

        Caretaker c = new Caretaker();
        c.setMemento(o.createMemento());

        o.setState("off");
        o.show();

        o.setmemento(c.getMemento());
        o.show();
    }

}
