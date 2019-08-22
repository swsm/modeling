package study1.behavior.objects.StatePattern.S3;

public class Context {
    private State state;
    public Context(State state) {
        this.setState(state);
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
        System.out.println("当前状态: " + state.getClass().getName());
    }
    public void request() {
        this.state.handle(this);
    }
}
