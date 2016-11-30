package InterpreterPattern.S2;

public class Scale extends AbstractExpression {

    @Override
    public void excute(String key, int value) {
        String scale = "";
        switch (Integer.valueOf(String.valueOf(value))) {
        case 1:
            scale = "低音";
            break;
        case 2:
            scale = "低音";
            break;
        case 3:
            scale = "高音";
            break;
        }
        System.out.print(scale + " ");
    }

}
