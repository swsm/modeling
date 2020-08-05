package study1.creator.AbstractFactoryPattern.S3;

public class SqlserverUser implements IUser {

    @Override
    public void insert(User user) {
        System.out.println("在sql server中给User表中增加一条记录");
    }

    @Override
    public User getUser(int id) {
        System.out.println("在sql server中根据id得到User表一条记录");
        return null;
    }

}
