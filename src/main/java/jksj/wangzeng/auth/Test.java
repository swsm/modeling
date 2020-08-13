package jksj.wangzeng.auth;

/**
 * @author swsm
 * @date 2020/7/24
 */
public class Test {

    public static void main(String[] args) {
        ApiAuthenticator apiAuthenticator = new DefaultApiAuthenticator();
        apiAuthenticator.auth("http://www.test.com/aaa/bbb?token=62ABE6749DBA236645414E111636E68B2E85451E7D115A0B1139FA3E9EC4D60EAEF5B3F07535EA59A0BB9043BA6CF2B59AF2BDAC94858EC12AD6C53510DE5477&appId=qqq&createTime=" + "1595584341078");
        
    }
    
}
