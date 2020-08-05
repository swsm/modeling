package study1.behavior.objects.VisitorPattern.S2;

import java.util.ArrayList;
import java.util.List;

public class ObjectStruture {
    private List<Element> elements = new ArrayList<Element>();
    public void attach(Element element) {
        this.elements.add(element);
    }
    public void detach(Element element) {
        this.elements.remove(element);
    }
    public void accept(Visitor visitor) {
        for (Element e : this.elements) {
            e.accept(visitor);
        }
    }
}
