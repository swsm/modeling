package study1.constuction.SimpleFactoryPattern.S2;

public class Main {

    public static void main(String[] args) throws Exception {
        Operation oper;
        oper = OperationFactory.createOperate("/");
        oper.setA(123);
        oper.setB(345);
        double res = oper.getResult();
        System.out.println("结果是: " + res);
    }

}
