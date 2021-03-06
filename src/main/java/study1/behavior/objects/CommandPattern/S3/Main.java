package study1.behavior.objects.CommandPattern.S3;

public class Main {
    public static void main(String[] args) {
        Barbecuer boy = new Barbecuer();
        Command bakeMuttonCommand1 = new BakeMuttonCommand(boy);
        Command bakeMuttonCommand2 = new BakeMuttonCommand(boy);
        Command bakeChickenWingCommand1 = new BakeChickenWingCommand(boy);
        Waiter girl = new Waiter();

        girl.setOrder(bakeChickenWingCommand1);
        girl.setOrder(bakeMuttonCommand1);
        girl.setOrder(bakeMuttonCommand2);

        girl.myNotify();

    }
}
