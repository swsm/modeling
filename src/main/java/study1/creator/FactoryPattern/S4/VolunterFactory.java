package study1.creator.FactoryPattern.S4;

public class VolunterFactory implements IFactory {

    @Override
    public LeiFeng createLeiFeng() {
        return new Volunteer();
    }

}
