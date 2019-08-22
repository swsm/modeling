package study2.creator.factory.factory2;

public class AimaBycleFactory implements IBycleFactory {


    @Override
    public IBycle buildBycle() {
        return new AimaBycle();
    }
}
