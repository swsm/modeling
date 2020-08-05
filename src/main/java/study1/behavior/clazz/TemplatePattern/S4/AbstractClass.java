package study1.behavior.clazz.TemplatePattern.S4;

abstract class AbstractClass {
    public abstract void primitiveOperation1();
    public abstract void primitiveOperation2();
    public void templateMethod() {
        this.primitiveOperation1();
        this.primitiveOperation2();
        System.out.println("");
    }
}
