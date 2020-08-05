package study1.behavior.objects.MediatorPattern.S1;

abstract class Colleague {
    protected Mediator mediator;
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}
