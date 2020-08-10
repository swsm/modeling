package jksj.wangzeng.ocp.good;

import java.awt.*;

/**
 * @author swsm
 * @date 2020/8/6
 */
public class AliyunImageStore implements ImageStore {
    
    private Image image;
    
    
    @Override
    public String upload(Image image, String bucketName) {
        createBucketIfNotExisting(bucketName);
        String accessToken = this.generateAccessToken();
        // 上传图片到阿里云
        return null;
    }

    @Override
    public Image download(String url) {
        String accesToken = generateAccessToken();
        // 从阿里云下载图片
        return null;
    }

    public void createBucketIfNotExisting(String bucketName) {
        //创建Bucket代码逻辑
        //失败抛出异常
    }

    public String generateAccessToken() {
        //根据accessToken/secretKey等生成access Token
        return "";
    }
}
