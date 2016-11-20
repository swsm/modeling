package CompositePattern.S2;

public class Main {

    public static void main(String[] args) {
        ConcreateCompany root = new ConcreateCompany("北京总公司");
        root.add(new HRDepartment("总公司人力资源部"));
        root.add(new FinanceDepartment("总公司财务部"));
        
        ConcreateCompany comp = new ConcreateCompany("上海华东分公司");
        comp.add(new HRDepartment("华东分公司人力资源部"));
        comp.add(new FinanceDepartment("华东分公司财务部"));
        root.add(comp);
        
        ConcreateCompany comp1 = new ConcreateCompany("南京分公司");
        comp1.add(new HRDepartment("南京分公司人力资源部"));
        comp1.add(new FinanceDepartment("南京分公司财务部"));
        root.add(comp1);
        
        ConcreateCompany comp2 = new ConcreateCompany("杭州分公司");
        comp2.add(new HRDepartment("杭州分公司人力资源部"));
        comp2.add(new FinanceDepartment("杭州分公司财务部"));
        root.add(comp2);
        
        System.out.println(" 结构图: ");
        root.display(1);
        
        System.out.println(" 职责 ");
        root.lineOfDuty();
    }

}
