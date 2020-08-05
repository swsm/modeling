package study1.constuction.CompositePattern.S2;

public class HRDepartment extends Company {

    public HRDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company c) {

    }

    @Override
    public void remove(Company c) {

    }

    @Override
    public void display(int depth) {
        String ss = "";
        for (int i = 0; i < depth; i++) {
            ss += "-";
        }
        System.out.println(ss + this.name);
    }

    @Override
    public void lineOfDuty() {
        System.out.println(this.name + "员工招聘培训管理");
    }

}
