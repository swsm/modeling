package VisitorPattern.S1;


public class Woman extends Person {

    @Override
    public void accept(Action visitor) {
        visitor.getWomanConclusion(this);
    }

}
