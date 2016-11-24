package MediatorPattern.S2;

public abstract class Country {
    protected UnitedNations mediator;
    public Country(UnitedNations mediator) {
        this.mediator = mediator;
    }
}
