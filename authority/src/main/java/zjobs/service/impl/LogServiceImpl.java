package zjobs.service.impl;

import org.springframework.stereotype.Service;
import zjobs.dao.LogDao;
import zjobs.entity.db.Log;
import zjobs.service.AbstractService;
import zjobs.service.LogService;

/**
 * 日志服务实现
 *
 * @author jiezhang
 */
@Service
public class LogServiceImpl extends AbstractService<Log, LogDao> implements LogService {
}
