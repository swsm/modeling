package AdapterPattern.S3;

public class ForeignCenter {
    private String name;
    
    public void zhAttack() {
        System.out.println("中锋" + this.name + "进攻");
    }
    
    public void zhDefense() {
        System.out.println("中锋" + this.name + "防守");
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
