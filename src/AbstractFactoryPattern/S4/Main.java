package AbstractFactoryPattern.S4;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        Department dept = new Department();
        IUser iu = DataAccess.createUser();
        iu.getUser(1);
        iu.insert(user);
        
        IDepartment id = DataAccess.createDepartment();
        id.insert(dept);
        id.getDepartment(1);
    }
}
