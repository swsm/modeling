package study1.behavior.objects.VisitorPattern.S1;


public class Man extends Person {

    @Override
    public void accept(Action visitor) {
        visitor.getManConclusion(this);
    }

}
