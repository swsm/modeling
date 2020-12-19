package jksj.wangzeng.testunit.example.two.restructure;

import com.google.common.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @author swsm
 * @date 2020/8/28
 */
public class RandomIdGenerator implements LogTranceIdGenerator {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RandomIdGenerator.class);
    
    @Override
    public String generate() {
        String substrOfHostName = getLastfieldOfHostName();
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        String id = String.format("%s-%d-%s", substrOfHostName, currentTimeMillis, randomString);
        return id;
    }

    private String getLastfieldOfHostName() {
        String substrOfHostName = null;
        String hostName = null;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
            substrOfHostName = this.getLastSubstrSplittedByDot(hostName);
        } catch (UnknownHostException e) {
            LOGGER.warn("Failed to get the hostname. ", e);
        }
        return substrOfHostName;
    }


    @VisibleForTesting
    protected String getLastSubstrSplittedByDot(String hostName) {
        String[] tokens = hostName.split("\\.");
        String substrOfHostName = tokens[tokens.length - 1];
        return substrOfHostName;
    }

    @VisibleForTesting
    protected String generateRandomAlphameric(int length) {
        
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit || isUppercase || isLowercase) {
                randomChars[count] = (char) randomAscii;
                ++count;
            }
        }
        return new String(randomChars);
    }

    public static void main(String[] args) {
        LogTranceIdGenerator logTranceIdGenerator = new RandomIdGenerator();
        System.out.println(logTranceIdGenerator.generate());
        System.out.println(logTranceIdGenerator.generate());
        System.out.println(logTranceIdGenerator.generate());
    }
    
    
    
}
