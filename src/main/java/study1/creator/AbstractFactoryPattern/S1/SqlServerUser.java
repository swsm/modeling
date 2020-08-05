package study1.creator.AbstractFactoryPattern.S1;

public class SqlServerUser {
    public void insert(User user) {
        System.out.println("在sql server中给User表增加一条记录");
    }
    public User getUser(int id) {
        System.out.println("在sql server中根据id得到user表的一条记录");
        return null;
    }
}
