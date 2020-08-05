package study1.constuction.Flyweight.S1;

public class Main {

    public static void main(String[] args) {
        WebSite fx = new WebSite("产品展示");
        fx.use();
        WebSite fy = new WebSite("产品展示");
        fy.use();
        WebSite fz = new WebSite("产品展示");
        fz.use();
        WebSite fl = new WebSite("博客");
        fl.use();
        WebSite fm = new WebSite("博客");
        fm.use();
        WebSite fn = new WebSite("博客");
        fn.use();
    }

}
