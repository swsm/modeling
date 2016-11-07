package FactoryPattern.S3;

public class Main1 {

    public static void main(String[] args) {
        LeiFeng studentA = SimpleFactory.createLeiFeng("学雷锋的大学生");
        studentA.buyRice();
        LeiFeng studentB = SimpleFactory.createLeiFeng("学雷锋的大学生");
        studentB.sweep();
        LeiFeng studentC = SimpleFactory.createLeiFeng("学雷锋的大学生");
        studentC.wash();
    }

}
