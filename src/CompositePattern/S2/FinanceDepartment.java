package CompositePattern.S2;

public class FinanceDepartment extends Company {
    
    public FinanceDepartment(String name) {
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
        System.out.println(this.name + "公司财务收支管理");
    }

}
