package study1.creator.PrototypePattern.S1;

public class Main {
    public static void main(String[] args) {
        Resume a = new Resume("大鸟");
        a.setPersonalInfo("男", "29");
        a.setWorkExperience("1998-2000", "XX公司");

        Resume b = new Resume("大鸟");
        b.setPersonalInfo("男", "29");
        b.setWorkExperience("1998-2000", "xx公司");

        Resume c = new Resume("大鸟");
        c.setPersonalInfo("男", "29");
        c.setWorkExperience("1998-2000", "xx公司");

        a.display();
        b.display();
        c.display();

    }


}
