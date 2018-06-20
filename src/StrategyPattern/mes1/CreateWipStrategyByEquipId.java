package StrategyPattern.mes1;


public class CreateWipStrategyByEquipId extends CreateWipStrategy {
    private CreateWipParam createWipParam;

    public CreateWipStrategyByEquipId(CreateWipParam createWipParam) {
        this.createWipParam = createWipParam;
    }

    public Wip createWip() {
        Wip wip = new Wip();
        wip.setLotNo("只有设备id的在制品");
        wip.setEquipId(createWipParam.getEquipId());
        return wip;
    }

}
