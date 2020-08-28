package jksj.wangzeng.testunit.example.two.restructure;


import org.junit.Assert;
import org.junit.Test;

/**
 * @author swsm
 * @date 2020/8/28
 */
public class RandomIdGeneratorTest {
    
    
    @Test
    public void testGetLastSubstrSplittedByDot() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualSubStr = idGenerator.getLastSubstrSplittedByDot("field1.field2.field3.field4");
        Assert.assertEquals("field4", actualSubStr);
        
        actualSubStr = idGenerator.getLastSubstrSplittedByDot("field1");
        Assert.assertEquals("field1", actualSubStr);
    }

    /**
     * 没有通过  null的会报空指针
     */
    @Test
    public void testGetLastSubstrSplittedByDot_nullOrEmpty() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualSubStr = idGenerator.getLastSubstrSplittedByDot(null);
        Assert.assertNull(actualSubStr);
        
        actualSubStr = idGenerator.getLastSubstrSplittedByDot("");
        Assert.assertEquals("", actualSubStr);
    }

    @Test 
    public void testGenerateRandomAlphameric() { 
        RandomIdGenerator idGenerator = new RandomIdGenerator(); 
        String actualRandomString = idGenerator.generateRandomAlphameric(6); 
        Assert.assertNotNull(actualRandomString); 
        Assert.assertEquals(6, actualRandomString.length()); 
        for (char c : actualRandomString.toCharArray()) { 
            Assert.assertTrue(('0' <= c && c <= '9') || ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')); 
        } 
    }

    // 此单元测试会失败，因为我们在代码中没有处理length<=0的情况 // 这部分优化留在第36、37节课中讲解 
    @Test 
    public void testGenerateRandomAlphameric_lengthEqualsOrLessThanZero() { 
        RandomIdGenerator idGenerator = new RandomIdGenerator(); 
        String actualRandomString = idGenerator.generateRandomAlphameric(0); 
        Assert.assertEquals("", actualRandomString); 
        actualRandomString = idGenerator.generateRandomAlphameric(-1); 
        Assert.assertNull(actualRandomString); 
    }
    
    
    
}
