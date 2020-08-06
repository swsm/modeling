package jksj.wangzeng.ocp.good;

import java.awt.*;

/**
 * @author swsm
 * @date 2020/8/6
 */
public class ImageProcessingJob {
    
    private static final String BUCKET_NAME = "bucketname";
    
    public void process() {
        ImageStore imageStore = new AliyunImageStore();
        Image image = imageStore.download("sdfs");
        imageStore.upload(image, BUCKET_NAME);
    }
    
}
