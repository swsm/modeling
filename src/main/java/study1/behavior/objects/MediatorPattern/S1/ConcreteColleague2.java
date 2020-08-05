package study1.behavior.objects.MediatorPattern.S1;

public class ConcreteColleague2 extends Colleague {

    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        this.mediator.send(message, this);
    }

    public void myNotify(String message) {
        System.out.println("同事2得到信息: " + message);
    }
}
