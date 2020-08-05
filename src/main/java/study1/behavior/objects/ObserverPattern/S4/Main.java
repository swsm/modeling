package study1.behavior.objects.ObserverPattern.S4;

public class Main {

    public static void main(String[] args) {
        ConcreateSubject a = new ConcreateSubject();
        a.attach(new ConcreateObserver(a, "X"));
        a.attach(new ConcreateObserver(a, "Y"));
        a.attach(new ConcreateObserver(a, "Z"));
        a.setSubjectState("ABC");
        a.myNotify();
    }

}
