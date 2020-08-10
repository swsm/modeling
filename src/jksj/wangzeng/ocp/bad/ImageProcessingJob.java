package jksj.wangzeng.ocp.bad;

import java.awt.*;

/**
 * @author swsm
 * @date 2020/8/6
 */
public class ImageProcessingJob {
    
    private static final String BUCKET_NAME = "ai_images_bucket";

    public void process() {
        Image image = null;// 处理图片，并封装为image对象
        AliyunImageStore imageStore = new AliyunImageStore();
        imageStore.createBucketIfNotExisting(BUCKET_NAME);
        String accessToken = imageStore.generateAccessToken();
        imageStore.uploadToAliyun(image, BUCKET_NAME, accessToken);
    }
    
}
