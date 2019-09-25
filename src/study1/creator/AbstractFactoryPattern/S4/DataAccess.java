package study1.creator.AbstractFactoryPattern.S4;

public class DataAccess {
    private static final String db = "Sqlserver";
    public static IUser createUser() {
        IUser result = null;
        if ("Sqlserver".equals(db)) {
            result = new SqlserverUser();
        } else if ("Access".equals(db)) {
            result = new AccessUser();
        }
        return result;
    }
    public static IDepartment createDepartment() {
        IDepartment result = null;
        if ("Sqlserver".equals(db)) {
            result = new SqlserverDepartment();
        } else if ("Access".equals(db)) {
            result = new AccessDepartment();
        }
        return result;
    }
}
