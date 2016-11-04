package SimpleFactoryPattern.S2;

public class OperationFactory {
    public static Operation createOperate(String operate) {
        Operation oper = null;
        switch (operate.charAt(0)) {
        case '+':
            oper = new OperationAdd();
            break;
        case '-':
            oper = new OperationSub();
            break;
        case '*':
            oper = new OperationMul();
            break;
        case '/':
            oper = new OperationDiv();
            break;
        }
        return oper;
    }
}
