package study1.creator.AbstractFactoryPattern.S2;

public class AccessUser implements IUser {

    @Override
    public void insert(User user) {
        System.out.println("在Access中给User表中增加一条记录");
    }

    @Override
    public User getUser(int id) {
        System.out.println("在Access中根据id得到User表一条记录");
        return null;
    }

}
