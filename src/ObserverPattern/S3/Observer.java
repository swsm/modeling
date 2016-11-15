package ObserverPattern.S3;

abstract class Observer {
    protected String name;
    protected Subject sub;
    public Observer(String name, Subject sub) {
        this.name = name;
        this.sub = sub;
    }
    public abstract void update();
}
