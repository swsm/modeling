package study1.behavior.objects.MementoPattern.S1;

public class GameRole {
    private int vit;
    private int atk;
    private int def;

    public void stateDisplay() {
        System.out.println("角色当前状态: ");
        System.out.println("体力: " + this.getVit());
        System.out.println("攻击力: " + this.getAtk());
        System.out.println("防御力: " + this.getDef());

    }

    public void getInitState() {
        this.vit = 100;
        this.atk = 100;
        this.def = 100;
    }

    public void fight() {
        this.vit = 0;
        this.atk = 0;
        this.def = 0;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
