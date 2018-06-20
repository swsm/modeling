package StrategyPattern.mes1;

public class CreateWipParam {
    private String equipId;
    private String workOrderId;
    private String preWipId;

    public CreateWipParam(String equipId) {
        this.equipId = equipId;
    }

    public CreateWipParam(String equipId, String workOrderId) {
        this.equipId = equipId;
        this.workOrderId = workOrderId;
    }

    public CreateWipParam(String equipId, String workOrderId, String preWipId) {
        this.equipId = equipId;
        this.workOrderId = workOrderId;
        this.preWipId = preWipId;
    }

    public String getEquipId() {
        return equipId;
    }

    public void setEquipId(String equipId) {
        this.equipId = equipId;
    }

    public String getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getPreWipId() {
        return preWipId;
    }

    public void setPreWipId(String preWipId) {
        this.preWipId = preWipId;
    }
}
