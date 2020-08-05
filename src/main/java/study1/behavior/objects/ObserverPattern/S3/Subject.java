package study1.behavior.objects.ObserverPattern.S3;

public interface Subject {
    public void attach(Observer observer);
    public void detach(Observer observer);
    public void myNotify();
    public String getAction();
    public void setAction(String action);


}
