package study1.creator.PrototypePattern.S4;

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

    public void setWorkExperience(String workDate, String company) {
        this.work.setWorkDate(workDate);
        this.work.setCompany(company);
    }

    public void display() {
        System.out.println(this.name + " " + this.sex + " " + this.age);
        System.out.println("工作经历: " + this.work.getCompany() + "  " + this.work.getWorkDate());
    }

    public Object clone() {
        Resume r = null;
        try {
            r = (Resume) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return r;
    }


}
