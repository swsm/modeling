package study1.behavior.objects.StatePattern.S3;

public class Main {

    public static void main(String[] args) {
        Context c = new Context(new ConcreateStateA());
        c.request();
        c.request();
        c.request();
        c.request();

    }

}
