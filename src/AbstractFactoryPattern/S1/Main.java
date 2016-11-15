package AbstractFactoryPattern.S1;

public class Main {

    public static void main(String[] args) {
        User u = new User();
        SqlServerUser su = new SqlServerUser();
        su.insert(u);
        su.getUser(1);
    }

}
