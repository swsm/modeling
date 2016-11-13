package FacadePattern.S2;

public class Facade {
    SubSystemOne one;
    SubSystemTwo two;
    SubSystemThree three;
    SubSystemFour four;
    
    public Facade() {
        this.one = new SubSystemOne();
        this.two = new SubSystemTwo();
        this.three = new SubSystemThree();
        this.four = new SubSystemFour();
    }
    
    public void methodA() {
        System.out.println("方法组A() --- ");
        this.one.methodOne();
        this.two.methodTwo();
        this.three.methodThree();
        this.four.methodFour();
    }
    
    public void methodB() {
        System.out.println("方法B() --- ");
        this.two.methodTwo();
        this.three.methodThree();
    }
}
