package study1.creator.AbstractFactoryPattern.S2;

public class AccessFactory implements IFactory {

    @Override
    public IUser createUser() {
        return new AccessUser();
    }

}
