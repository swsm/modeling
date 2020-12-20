package study2.alerm;

/**
 * @author swsm
 * @date 2020/11/4
 */
public interface IAlertHandler {
    
    void handle(String apiSign, int type, long time);
    
}
