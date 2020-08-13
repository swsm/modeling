package jksj.wangzeng.pocket.pinxue.enums;

/**
 * @author swsm
 * @date 2020/8/12
 */
public enum Status {
    
    TO_BE_EXECUTED(0, "执行中"),
    EXECUTED_FAILED(1, "执行失败"),
    EXECUTED_SUCCESS(2, "执行成功");
    
    private int val;
    private String text;

    Status(int val, String text) {
        this.val = val;
        this.text = text;
    }

    public int getVal() {
        return val;
    }

    public String getText() {
        return text;
    }
}
