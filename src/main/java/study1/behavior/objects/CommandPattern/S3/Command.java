package study1.behavior.objects.CommandPattern.S3;

public abstract class Command {
    protected Barbecuer receiver;

    public Command(Barbecuer receiver) {
        this.receiver = receiver;
    }

    abstract public void excuteCommand();

    @Override
    public String toString() {
        if (this instanceof  BakeChickenWingCommand) {
            return "烤鸡翅";
        } else {
            return this.getClass().getName();
        }

    }

}
