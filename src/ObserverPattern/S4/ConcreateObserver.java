package ObserverPattern.S4;

public class ConcreateObserver extends Observer {
    private String name;
    private String observerState;
    private ConcreateSubject subject;
    
    public ConcreateObserver(ConcreateSubject subject, String name) {
        this.subject = subject;
        this.name = name;
    }

    @Override
    public void update() {
        this.observerState = this.subject.getSubjectState();
        System.out.println("观察者" + this.name + "的新状态是" + this.observerState);
    }

    public ConcreateSubject getSubject() {
        return subject;
    }

    public void setSubject(ConcreateSubject subject) {
        this.subject = subject;
    }
}
