package study1.behavior.objects.StrategyPattern.mes1;

public class WipFactory {

    private CreateWipStrategy createWipStrategy;

    public WipFactory(String type, CreateWipParam createWipParam) {
        if ("设备".equals(type)) {
            createWipStrategy = new CreateWipStrategyByEquipId(createWipParam);
        } else if ("设备工单".equals(type)) {
            createWipStrategy = new CreateWipStrategyByEquipIdAndOrderId(createWipParam);
        } else if ("设备工单在制品".equals(type)) {
            createWipStrategy = new CreateWipStrategyByEquipIdAndOrderIdAndPreWip(createWipParam);
        }
    }

    public Wip createWip() {
        return createWipStrategy.createWip();
    }
}
