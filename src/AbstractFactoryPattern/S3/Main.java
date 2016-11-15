package AbstractFactoryPattern.S3;

public class Main {

    public static void main(String[] args) {
        User user = new User();
        Department dep = new Department();
        IFactory factory = new AccessFactory();
        IUser iu = factory.createUser();
        iu.insert(user);
        iu.getUser(1);
        
        IDepartment id = factory.createDepartment();
        id.insert(dep);
        id.getDepartment(1);
    }

}
