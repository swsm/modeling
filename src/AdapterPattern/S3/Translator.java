package AdapterPattern.S3;

public class Translator extends Player {

    private ForeignCenter wjzf = new ForeignCenter();
    public Translator(String name) {
        super(name);
        wjzf.setName(name);
    }

    @Override
    public void attack() {
        this.wjzf.zhAttack();
        
    }

    @Override
    public void defense() {
        this.wjzf.zhDefense();
    }

}
