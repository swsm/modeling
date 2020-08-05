package study1.behavior.clazz.InterpreterPattern.S1;

public class TerminalExpression extends AbstractExpression {

    @Override
    public void interpret(Context context) {
        System.out.println("终端解释器");
    }

}
