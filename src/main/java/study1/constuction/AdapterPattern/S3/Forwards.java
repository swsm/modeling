package study1.constuction.AdapterPattern.S3;

public class Forwards extends Player {
    public Forwards(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("前锋" + this.name + "进攻");
    }

    @Override
    public void defense() {
        System.out.println("前锋" + this.name + "防守");
    }


}
