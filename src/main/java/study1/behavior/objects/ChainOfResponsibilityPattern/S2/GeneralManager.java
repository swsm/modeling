package study1.behavior.objects.ChainOfResponsibilityPattern.S2;

public class GeneralManager extends Manager {

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void requestApplications(Request request) {
        if (request.getRequestType().equals("请假")) {
            System.out.println(this.name + ": " + request.getRequestContent() + request.getNumber() + "被批准");
        }
        if (request.getRequestType().equals("加薪") && request.getNumber() <= 500) {
            System.out.println(this.name + ": " + request.getRequestContent() + request.getNumber() + "被批准");
        } else if (request.getRequestType().equals("加薪") && request.getNumber() > 500) {
            System.out.println(this.name + ": " + request.getRequestContent() + request.getNumber() + "再说吧");
        }
    }


}
