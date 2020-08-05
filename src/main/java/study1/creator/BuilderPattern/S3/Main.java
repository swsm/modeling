package study1.creator.BuilderPattern.S3;

public class Main {

    public static void main(String[] args) {
        Director director = new Director();
        Builder b1 = new ConcreateBuilder1();
        Builder b2 = new ConcreateBuilder2();

        director.construct(b1);
        Product p1 = b1.getResult();
        p1.show();

        director.construct(b2);
        Product p2 = b2.getResult();
        p2.show();
    }

}
