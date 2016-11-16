package StatePattern.S3;

public class ConcreateStateB extends State {

    @Override
    public void handle(Context context) {
        context.setState(new ConcreateStateA());
    }

}
