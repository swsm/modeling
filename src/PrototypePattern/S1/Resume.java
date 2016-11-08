package PrototypePattern.S1;

public class Resume {
    private String name;
    private String sex;
    private String age;
    private String timeArea;
    private String company;
    
    public Resume(String name) {
        this.name = name;
    }
    
    public void setPersonalInfo(String sex, String age) {
        this.age = age;
        this.sex = sex;
    }
    
    public void setWorkExperience(String timeArea, String company) {
        this.timeArea = timeArea;
        this.company = company;
    }
    
    public void display() {
        System.out.println(this.name + this.sex + this.age);
        System.out.println("工作经历: " + this.timeArea + this.company);
    }
}
