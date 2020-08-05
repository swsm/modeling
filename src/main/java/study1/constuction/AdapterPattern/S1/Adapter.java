package study1.constuction.AdapterPattern.S1;

public class Adapter extends Target {
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        this.adaptee.specificRequest();
    }
}
