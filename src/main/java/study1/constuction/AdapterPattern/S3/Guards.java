package study1.constuction.AdapterPattern.S3;

public class Guards extends Player {
    public Guards(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("后卫" + this.name + "进攻");
    }

    @Override
    public void defense() {
        System.out.println("后卫" + this.name + "防守");
    }


}
