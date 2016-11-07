package FactoryPattern.S1;

public class Main {

    public static void main(String[] args) throws Exception {
        Operation oper;
        oper = OperationFactory.createOperation("/");
        oper.setA(1);
        oper.setB(0);
        double result = oper.getResult();
        System.out.println("结果是: " + result );
    }

}
