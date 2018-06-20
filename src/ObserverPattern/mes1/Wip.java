package ObserverPattern.mes1;

import java.util.Observable;

public class Wip extends Observable {

    public Wip(String lotNo) {
        this.lotNo = lotNo;
    }

    private String lotNo;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        if ("已完成".equals(status)) {
            setChanged();
            this.notifyObservers();
        }
    }


    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

}
