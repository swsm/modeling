package study1.constuction.SimpleFactoryPattern.S1;

public class Operation {
    public static double getResult(double numberA, double numberB, char operate) {
        double result = 0;
        switch (operate) {
        case '+':
            result = numberA + numberB;
            break;
        case '-':
            result = numberA - numberB;
            break;
        case '*':
            result = numberA * numberB;
            break;
        case '/':
            result = numberA / numberB;
            break;
        }
        return result;
    }
}
