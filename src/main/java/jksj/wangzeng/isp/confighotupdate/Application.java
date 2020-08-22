package jksj.wangzeng.isp.confighotupdate;

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
    }
    
    
}
