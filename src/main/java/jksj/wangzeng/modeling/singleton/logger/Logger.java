package jksj.wangzeng.modeling.singleton.logger;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author swsm
 * @date 2020/8/26
 */
public class Logger {
    
    private FileWriter fileWriter;
    private static final Logger LOGGER = new Logger();
    
    private Logger() {
        try {
            this.fileWriter = new FileWriter("./log.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Logger getInstance() {
        return LOGGER;
    }
    
    public void log(String text) {
        try {
            this.fileWriter.write(text);
            this.fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
