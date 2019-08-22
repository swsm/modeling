package study1.behavior.objects.StrategyPattern.mes1;

public class Wip {

    private String lotNo;
    private String equipId;
    private String orderId;
    private String preWipId;

    public String getEquipId() {
        return equipId;
    }

    public void setEquipId(String equipId) {
        this.equipId = equipId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public String getPreWipId() {
        return preWipId;
    }

    public void setPreWipId(String preWipId) {
        this.preWipId = preWipId;
    }

    @Override
    public String toString() {
        return "Wip{" +
                "lotNo='" + lotNo + '\'' +
                ", equipId='" + equipId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", preWipId='" + preWipId + '\'' +
                '}';
    }
}

