package zjobs.entity.redis;

import org.apache.commons.lang.StringUtils;
import org.redisson.Config;
import org.redisson.Redisson;

/**
 * redis.properties 配置文件
 * Created by jiezhang on 2017/6/20.
 */
public class RedisConf {
    private String masterName;
    private String host;
    private String port;
    private Long maxSerial;

    private Redisson redisson;

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Redisson getRedisson() {
        return redisson;
    }

    public void setRedisson(Redisson redisson) {
        this.redisson = redisson;
    }

    public Long getMaxSerial() {
        return maxSerial;
    }

    public void setMaxSerial(Long maxSerial) {
        this.maxSerial = maxSerial;
    }

    public void init() {
        Config config = new Config();
        if (StringUtils.isBlank(masterName)) {
            config.useSingleServer().setAddress(host + ":" + port);
        } else {
            config.useSentinelConnection().setMasterName(masterName)
                    .addSentinelAddress(host + ":" + port);
        }
        this.redisson = Redisson.create(config);
    }


}
