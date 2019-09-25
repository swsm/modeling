package study1.behavior.objects.CommandPattern.S3;

public class BakeChickenWingCommand extends Command {

    public BakeChickenWingCommand(Barbecuer receiver) {
        super(receiver);
    }

    @Override
    public void excuteCommand() {
        this.receiver.bakeChickenWing();
    }

}
