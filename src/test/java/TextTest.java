import jksj.wangzeng.testunit.Text;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author swsm
 * @date 2020/8/23
 */
public class TextTest {
    
    @Test
    public void testToNumber() {
        Text text = new Text("123");
        Assert.assertEquals(new Integer("123"), text.toNumber());
    }
    
}
