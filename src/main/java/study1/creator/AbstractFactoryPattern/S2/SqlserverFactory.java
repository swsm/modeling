package study1.creator.AbstractFactoryPattern.S2;

public class SqlserverFactory implements IFactory {

    @Override
    public IUser createUser() {
        return new SqlserverUser();
    }

}
