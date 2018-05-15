package zjobs.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import zjobs.entity.SnowFlake;
import zjobs.service.SequenceService;

/**
 * twitter的snowflake算法 -- java实现
 * git 地址https://github.com/beyondfengyu/SnowFlake/blob/master/SnowFlake.java
 *
 * @author beyond
 * @date 2016/11/26
 */
@Service
public class SnowflakeSequenceImpl implements SequenceService {
    @Value("#{properties.server_dataCenterId}")
    private String dataCenterId;

    @Value("#{properties.server_machineId}")
    private String machineId;


    /**
     * 产生下一个ID
     *
     * @return
     */
    @Override
    public synchronized long getSequence() {
        SnowFlake snowFlake = new SnowFlake(Integer.valueOf(this.dataCenterId), Integer.valueOf(this.machineId));
        return snowFlake.getNext();
    }

}
