package jksj.wangzeng.isp.confighotupdate;

/**
 * @author swsm
 * @date 2020/8/22
 */
public class MysqlConfig {
    
    private ConfigSource configSource;
    private String address;
    private int timeout;
    private int maxTotal;
    
    public MysqlConfig(ConfigSource configSource) {
        this.configSource = configSource;
    }

    public void update() {
        
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }
}
