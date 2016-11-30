package InterpreterPattern.S2;

public abstract class AbstractExpression {
    public void interpret(PlayContext context) {
        if (context.getText().length() == 0) {
            return;
        } else {
            String playKey = context.getText().substring(0, 1);
            context.setText(context.getText().substring(2));
            int playValue = Integer.parseInt(context.getText().substring(0, context.getText().indexOf(" ")));
            context.setText(context.getText().substring(context.getText().indexOf(" ") + 1));
            this.excute(playKey, playValue);
        }
    }
    
    public abstract void excute(String key, int value);
}
