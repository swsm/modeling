package InterpreterPattern.S2;

public class Main {
    public static void main(String[] args) {
        PlayContext context = new PlayContext();
        System.out.println("上海滩: ");
        context.setText("O 2 E 1 G 1 A 3 E 1 G 1 D 3 E 1 G 1 A 1 O 3 C 1 0 2 A 1 G 1 C 1 E 1 D 3 ");
        AbstractExpression expression = null;
        while (context.getText().length() > 0) {
            String str = context.getText().substring(0, 1);
            switch (str.charAt(0)) {
            case 'O':
                expression  = new Scale();
                break;
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'A':
            case 'B':
            case 'P': 
                expression = new Note();
                break;
            }
            
            expression.interpret(context);
        }
    }

}
