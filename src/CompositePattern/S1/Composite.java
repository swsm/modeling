package CompositePattern.S1;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    private List<Component> children = new ArrayList<Component>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        this.children.add(c);
    }

    @Override
    public void remove(Component c) {
        this.children.remove(c);
    }

    @Override
    public void display(int depth) {
        String ss = "";
        for (int i = 0; i < depth; i++) {
            ss += "-";
        }
        System.out.println(ss + this.name);
        for(Component c : this.children) {
            c.display(depth + 2);
        }
    }

}
