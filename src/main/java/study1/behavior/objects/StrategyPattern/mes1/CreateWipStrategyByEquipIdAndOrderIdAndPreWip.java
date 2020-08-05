package study1.behavior.objects.StrategyPattern.mes1;


public class CreateWipStrategyByEquipIdAndOrderIdAndPreWip extends CreateWipStrategy {
    private CreateWipParam createWipParam;

    public CreateWipStrategyByEquipIdAndOrderIdAndPreWip(CreateWipParam createWipParam) {
        this.createWipParam = createWipParam;
    }

    public Wip createWip() {
        Wip wip = new Wip();
        wip.setLotNo("有设备id工单id在制品id的在制品");
        wip.setEquipId(createWipParam.getEquipId());
        wip.setOrderId(createWipParam.getWorkOrderId());
        wip.setPreWipId(createWipParam.getPreWipId());
        return wip;
    }

}
