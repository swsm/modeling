package MediatorPattern.S1;

public class ConcreteMediator extends Mediator {
    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;
    
    
    @Override
    public void send(String message, Colleague colleague) {
        if(this.colleague1.getClass().getName().equals(colleague.getClass().getName())) {
            this.colleague2.myNotify(message);
        } else {
            this.colleague1.myNotify(message);
        }
    }


    public ConcreteColleague1 getColleague1() {
        return colleague1;
    }


    public void setColleague1(ConcreteColleague1 colleague1) {
        this.colleague1 = colleague1;
    }


    public ConcreteColleague2 getColleague2() {
        return colleague2;
    }


    public void setColleague2(ConcreteColleague2 colleague2) {
        this.colleague2 = colleague2;
    }
    
}
