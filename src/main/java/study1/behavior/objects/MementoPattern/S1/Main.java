package study1.behavior.objects.MementoPattern.S1;

public class Main {

    public static void main(String[] args) {
        GameRole lixiaoyao = new GameRole();
        lixiaoyao.getInitState();
        lixiaoyao.stateDisplay();

        GameRole bakeUp = new GameRole();
        bakeUp.setVit(lixiaoyao.getVit());
        bakeUp.setAtk(lixiaoyao.getAtk());
        bakeUp.setDef(lixiaoyao.getDef());

        lixiaoyao.fight();
        lixiaoyao.stateDisplay();

        lixiaoyao.setVit(bakeUp.getVit());
        lixiaoyao.setAtk(bakeUp.getAtk());
        lixiaoyao.setDef(bakeUp.getDef());

        lixiaoyao.stateDisplay();
    }

}
