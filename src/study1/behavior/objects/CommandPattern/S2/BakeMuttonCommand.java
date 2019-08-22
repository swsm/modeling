package study1.behavior.objects.CommandPattern.S2;

public class BakeMuttonCommand extends Command {

    public BakeMuttonCommand(Barbecuer receiver) {
        super(receiver);
    }

    @Override
    public void excuteCommand() {
        this.receiver.bakeMutton();
    }

}
