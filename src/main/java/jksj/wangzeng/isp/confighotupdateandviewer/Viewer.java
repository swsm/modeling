package jksj.wangzeng.isp.confighotupdateandviewer;

import java.util.Map;

/**
 * @author swsm
 * @date 2020/8/22
 */
public interface Viewer {
    
    String outputInPlainText();
    Map<String, String> output();
    
}
