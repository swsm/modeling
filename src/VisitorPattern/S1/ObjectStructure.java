package VisitorPattern.S1;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {
    private List<Person> elements = new ArrayList<Person>();
    public void attach(Person element) {
        this.elements.add(element);
    }
    public void detach(Person element) {
        this.elements.remove(element);
    }
    public void display(Action visitor) {
        for (Person e : this.elements) {
            e.accept(visitor);
        }
    }
}
