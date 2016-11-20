package CommandPattern.S4;

public class ConcreteCommand extends Command {

    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }
    @Override
    public void execute() {
        this.receiver.action();
    }

}
