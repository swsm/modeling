package study1.behavior.objects.ChainOfResponsibilityPattern.S2;

public class CommonManager extends Manager {

    public CommonManager(String name) {
        super(name);
    }

    @Override
    public void requestApplications(Request request) {
        if (request.getRequestType().equals("请假") && request.getNumber() <= 2) {
            System.out.println(this.name + ": " + request.getRequestContent() + request.getNumber() + "被批准");
        } else {
            if (this.superior != null) {
                this.superior.requestApplications(request);
            }
        }
    }


}
