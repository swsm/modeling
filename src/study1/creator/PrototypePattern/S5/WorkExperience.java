package study1.creator.PrototypePattern.S5;

public class WorkExperience implements Cloneable {
    private String workDate;
    private String company;

    public Object clone() {
        WorkExperience w = null;
        try {
            w = (WorkExperience)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return w;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
