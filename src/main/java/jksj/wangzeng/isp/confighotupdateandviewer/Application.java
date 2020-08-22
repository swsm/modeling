package jksj.wangzeng.isp.confighotupdateandviewer;

/**
 * @author swsm
 * @date 2020/8/22
 */
public class Application {
    
    static final ConfigSource configSource = new ZookeeperConfigSource();
    public static final RedisConfig redisConfig = new RedisConfig(configSource);
    public static final KafkaConfig kafkaCofnig = new KafkaConfig(configSource);
    public static final MysqlConfig mysqlCofnig = new MysqlConfig(configSource);

    public static void main(String[] args) {
        ScheduledUpdater redisScheduledUpdater = new ScheduledUpdater(redisConfig, 30, 300);
        redisScheduledUpdater.run();

        ScheduledUpdater kafkaScheduledUpdater = new ScheduledUpdater(kafkaCofnig, 30, 300);
        kafkaScheduledUpdater.run();
        
        SimpleHttpServer simpleHttpServer = new SimpleHttpServer("127.0.0.1", 2389);
        simpleHttpServer.addViewers("/config", redisConfig);
        simpleHttpServer.addViewers("/config", mysqlCofnig);
        simpleHttpServer.run();
    }
    
    
}
