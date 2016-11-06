package ProxyPattern.S2;

public class Proxy {
    SchoolGirl mm;
    public Proxy(SchoolGirl mm) {
        this.mm = mm;
    }
    public void giveDolls() {
        System.out.println(this.mm.getName() + "送你洋娃娃");
    }
    public void giveFlowers() {
        System.out.println(this.mm.getName() + "送你鲜花");
    }
    public void giveChocolate() {
        System.out.println(this.mm.getName() + "送你巧克力");
    }
}
