package CommandPattern.S2;

public class BakeChickenWingCommand extends Command {

    public BakeChickenWingCommand(Barbecuer receiver) {
        super(receiver);
    }

    @Override
    public void excuteCommand() {
        this.receiver.bakeChickenWing();
    }

}
