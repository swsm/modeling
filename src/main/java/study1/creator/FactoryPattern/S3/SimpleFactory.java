package study1.creator.FactoryPattern.S3;

public class SimpleFactory {
    public static LeiFeng createLeiFeng(String type) {
        LeiFeng result = null;
        if ("学雷锋的大学生".equals(type)) {
            result = new Undergraduate();
        } else if ("社区志愿者".equals(type)) {
            result = new Volunteer();
        }
        return result;
    }
}
