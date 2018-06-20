package StrategyPattern.mes1;


public class CreateWipStrategyByEquipIdAndOrderId extends CreateWipStrategy {
    private CreateWipParam createWipParam;

    public CreateWipStrategyByEquipIdAndOrderId(CreateWipParam createWipParam) {
        this.createWipParam = createWipParam;
    }

    public Wip createWip() {
        Wip wip = new Wip();
        wip.setLotNo("有设备id工单id的在制品");
        wip.setEquipId(createWipParam.getEquipId());
        wip.setOrderId(createWipParam.getWorkOrderId());
        return wip;
    }

}
