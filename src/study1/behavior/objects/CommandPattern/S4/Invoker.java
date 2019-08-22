package study1.behavior.objects.CommandPattern.S4;

public class Invoker {
    private Command command;

    public void executeCommand() {
        this.command.execute();
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
