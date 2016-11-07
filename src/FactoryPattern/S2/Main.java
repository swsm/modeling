package FactoryPattern.S2;

public class Main {

    public static void main(String[] args) throws Exception {
        IFactory operFactory = new AddFactory();
        Operation oper = operFactory.createOperation();
        oper.setA(1);
        oper.setB(3);
        double result = oper.getResult();
        System.out.println("结果是：" + result);
    }

}
