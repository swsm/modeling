package MementoPattern.S3;

public class Main {

    public static void main(String[] args) {
        GameRole lixiaoyao = new GameRole();
        lixiaoyao.getInitState();
        lixiaoyao.stateDisplay();
        
        RoleStateCaretaker stateAdmin = new RoleStateCaretaker();
        stateAdmin.setMemento(lixiaoyao.saveState());
        
        lixiaoyao.fight();
        lixiaoyao.stateDisplay();
        
        lixiaoyao.RecoveryState(stateAdmin.getMemento());
        lixiaoyao.stateDisplay();
    }

}
