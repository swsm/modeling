package study1.constuction.CompositePattern.S1;

public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        System.out.println("Cannot add to a leaf");
    }

    @Override
    public void remove(Component c) {
        System.out.println("Cannot remove from a leaf");
    }

    @Override
    public void display(int depth) {
        String ss = "";
        for (int i = 0; i < depth; i++) {
            ss += "-";
        }
        System.out.println(ss + this.name);
    }

}
