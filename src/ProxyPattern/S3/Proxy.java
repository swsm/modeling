package ProxyPattern.S3;

public class Proxy implements IGiveGift {
    Pursuit gg;
    public Proxy(SchoolGirl mm) {
        gg = new Pursuit(mm);
    }

    @Override
    public void giveDolls() {
        this.gg.giveDolls();
    }

    @Override
    public void giveFlowers() {
        this.gg.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        this.gg.giveChocolate();
    }
    
}
