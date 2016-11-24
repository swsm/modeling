package MediatorPattern.S2;

public class USA extends Country {

    public USA(UnitedNations mediator) {
        super(mediator);
    }
    
    public void declare(String message) {
        this.mediator.declare(message, this);
    }
    
    public void getMessage(String message) {
        System.out.println("美国获得对方的信息: " + message);
    }

}
