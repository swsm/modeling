package study2.alerm;

/**
 * @author swsm
 * @date 2020/11/4
 */
public class AlertInfo {
    
    private String content;
    
    private String head;
    
    private String[] to;

    public AlertInfo(String content, String head, String[] to) {
        this.content = content;
        this.head = head;
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }
}
