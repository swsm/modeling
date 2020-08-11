package jksj.wangzeng.ocp.bad;

import java.awt.*;

/**
 * @author swsm
 * @date 2020/8/6
 */
public class AliyunImageStore {
    
    private String bucketName;
    
    private Image image;
    
    private String accessToken;
    
    public void createBucketIfNotExisting(String bucketName) {
        //创建Bucket代码逻辑
        //失败抛出异常
    }
    
    public String generateAccessToken() {
        //根据accessToken/secretKey等生成access Token
        return "";
    }
    
    public String uploadToAliyun(Image image, String bucketName, String accessToken) {
        //上传图片到阿里云
        //返回图片存储在阿里云上的地址(url)
        return "";
    }
    
    public Image downloadFromAliyun(String url, String accessToken) {
        //从阿里云下载图片
        
        return null;
    }
    
}
