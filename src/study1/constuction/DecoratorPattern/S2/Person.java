package study1.constuction.DecoratorPattern.S2;

public class Person {

    private String name;
    public Person(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println(name + "的装扮 ");
    }
}
