package IteratorPattern.S1;

public class Main {
    public static void main(String[] args) {
        ConcreteAggregate a = new ConcreteAggregate();
        a.insertOne(0, "大鸟");
        a.insertOne(1, "小菜");
        a.insertOne(2, "行李");
        a.insertOne(3, "老外");
        a.insertOne(4, "公家内部员工");
        a.insertOne(5, "小偷");
        
        //Iterator i = new ConcreteIterator(a);
        Iterator i = new ConcreteIteratorDesc(a);
        Object item = i.first();
        while (!i.isDone()) {
            System.out.println(i.currentItem() + "请买车票!");
            i.next();
        }
        
    }
}
