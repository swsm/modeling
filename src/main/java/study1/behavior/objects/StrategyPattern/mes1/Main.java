package study1.behavior.objects.StrategyPattern.mes1;

public class Main {

    public static void main(String[] args) {
        System.out.println(new WipFactory("设备", new CreateWipParam("设备1")).createWip().toString());
        System.out.println(new WipFactory("设备工单", new CreateWipParam("设备1", "工单1")).createWip().toString());
        System.out.println(new WipFactory("设备工单在制品", new CreateWipParam("设备1", "工单1", "在制品1")).createWip().toString());
    }
}
