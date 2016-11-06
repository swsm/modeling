package DecoratorPattern.S1;

public class Person {
    private String name;
    
    public Person(String name) {
        this.name = name;
    }

    public void wareTshirts() {
        System.out.print("大T恤  ");
    }
    
    public void wareBigTrouser() {
        System.out.print("垮裤  ");
    }
    
    public void wareSneakers() {
        System.out.print("破球鞋  ");
    }
    
    public void wareSuit() {
        System.out.print("西装  ");
    }
    
    public void wareTie() {
        System.out.print("领带   ");
    }
    
    public void wareLeatherShoes() {
        System.out.print("皮鞋 ");
    }
    
    public void show() {
        System.out.println(this.name + "的装扮");
    }
}
