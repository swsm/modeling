package Flyweight.S1;

public class WebSite {
    private String name = "";
    public WebSite(String name) {
        this.name = name;
    }
    public void use() {
        System.out.println("网站分类: " + this.name);
    }
}
