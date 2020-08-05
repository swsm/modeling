package study1.behavior.objects.CommandPattern.S2;

public abstract class Command {
    protected Barbecuer receiver;

    public Command(Barbecuer receiver) {
        this.receiver = receiver;
    }

    abstract public void excuteCommand();

}
