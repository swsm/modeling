package StatePattern.S3;

public class ConcreateStateA extends State {

    @Override
    public void handle(Context context) {
        context.setState(new ConcreateStateB());
    }

}
