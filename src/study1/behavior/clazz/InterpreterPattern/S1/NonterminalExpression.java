package study1.behavior.clazz.InterpreterPattern.S1;

public class NonterminalExpression extends AbstractExpression {

    @Override
    public void interpret(Context context) {
        System.out.println("非终端解释器");
    }

}
