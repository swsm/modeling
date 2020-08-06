package jksj.wangzeng.ocp.good;

import java.awt.*;

/**
 * @author swsm
 * @date 2020/8/6
 */
public interface ImageStore {
    
    String upload(Image image, String bucketName);
    Image download(String url);
    
}
