package MementoPattern.S2;

public class Originator {
    private String state;

    public Memento createMemento() {
        return new Memento(state);
    }
    
    public void setmemento(Memento memento) {
        this.state = memento.getState();
    }
    
    public void show() {
        System.out.println("State= " + this.state);
    }
    
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
}
