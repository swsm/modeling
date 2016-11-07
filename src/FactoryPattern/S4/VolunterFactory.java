package FactoryPattern.S4;

public class VolunterFactory implements IFactory {

    @Override
    public LeiFeng createLeiFeng() {
        return new Volunteer();
    }

}
