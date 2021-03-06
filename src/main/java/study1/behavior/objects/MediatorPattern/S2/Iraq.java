package study1.behavior.objects.MediatorPattern.S2;

public class Iraq extends Country {

    public Iraq(UnitedNations mediator) {
        super(mediator);
    }

    public void declare(String message) {
        this.mediator.declare(message, this);
    }

    public void getMessage(String message) {
        System.out.println("伊拉克获得对方信息: " + message);
    }

}
