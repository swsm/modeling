package study1.constuction.DecoratorPattern.S4;

public class Person {
    public Person() {
    }

    private String name;
    public Person(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println(this.name + "的装扮");
    }
}
