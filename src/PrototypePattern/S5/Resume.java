package PrototypePattern.S5;

public class Resume implements Cloneable {
    private String name;
    private String sex;
    private String age;
    
    private WorkExperience work;
    
    public Resume(String name) {
        this.name = name;
        this.work = new WorkExperience();
    }
    
    public void setPersonalInfo(String sex, String age) {
        this.age = age;
        this.sex = sex;
    }
    
    private Resume(WorkExperience work) {
        this.work = (WorkExperience)work.clone();
    }
    
    public void setWorkExperience(String workDate, String company) {
        this.work.setWorkDate(workDate);
        this.work.setCompany(company);
    }
    
    public void display() {
        System.out.println(this.name + " " + this.sex + " " + this.age);
        System.out.println("工作经历: " + this.work.getCompany() + "  " + this.work.getWorkDate());
    }
    
    public Object clone() {
        Resume obj = new Resume(this.work);
        obj.name = this.name;
        obj.age = this.age;
        obj.sex = this.sex;
        return obj;
    }
    
    
}
