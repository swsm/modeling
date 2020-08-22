package jksj.wangzeng.isp.confighotupdateandviewer;

import java.util.Map;

/**
 * @author swsm
 * @date 2020/8/22
 */
public class MysqlConfig implements Viewer {
    
    private ConfigSource configSource;
    private String address;
    private int timeout;
    private int maxTotal;
    
    public MysqlConfig(ConfigSource configSource) {
        this.configSource = configSource;
    }



    @Override
    public String outputInPlainText() {
        return null;
    }

    @Override
    public Map<String, String> output() {
        return null;
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
