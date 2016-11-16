package AbstractFactoryPattern.S4;

public class MainReflect {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        User user = new User();
        Department dept = new Department();
        IUser iu = (IUser) Class.forName("AbstractFactoryPattern.S4.SqlserverUser").newInstance();
        iu.getUser(1);
        iu.insert(user);
        
        IDepartment id = (IDepartment) Class.forName("AbstractFactoryPattern.S4.AccessDepartment").newInstance();
        id.insert(dept);
        id.getDepartment(1);
    }

}
