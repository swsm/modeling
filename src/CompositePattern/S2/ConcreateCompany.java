package CompositePattern.S2;

import java.util.ArrayList;
import java.util.List;

public class ConcreateCompany extends Company {
    private List<Company> children = new ArrayList<Company>();

    public ConcreateCompany(String name) {
        super(name);
    }

    @Override
    public void add(Company c) {
        this.children.add(c);
    }

    @Override
    public void remove(Company c) {
        this.children.remove(c);
    }

    @Override
    public void display(int depth) {
        String ss = "";
        for (int i = 0; i < depth; i++) {
            ss += "-";
        }
        System.out.println(ss + this.name);
        for (Company c : this.children) {
            c.display(depth + 2);
        }
    }

    @Override
    public void lineOfDuty() {
        for (Company c : this.children) {
            c.lineOfDuty();
        }
    }

}
