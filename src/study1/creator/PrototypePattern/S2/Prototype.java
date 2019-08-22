package study1.creator.PrototypePattern.S2;

public abstract class Prototype implements Cloneable {
    private String id;
    public Prototype(String id) {
        this.setId(id);
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
