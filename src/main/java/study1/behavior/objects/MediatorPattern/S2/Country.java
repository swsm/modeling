package study1.behavior.objects.MediatorPattern.S2;

public abstract class Country {
    protected UnitedNations mediator;
    public Country(UnitedNations mediator) {
        this.mediator = mediator;
    }
}
