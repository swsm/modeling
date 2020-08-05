package study1.behavior.objects.CommandPattern.S2;

public class Waiter {
    private Command command;

    public void setOrder(Command command) {
        this.command = command;
    }
    public void myNotify() {
        this.command.excuteCommand();
    }
}
