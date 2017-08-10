package zjobs.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import zjobs.entity.db.Dict;
import zjobs.service.DictService;
import zjobs.service.RedisService;

import javax.servlet.ServletContext;

/**
 * Created by jiezhang on 2017/6/15.
 */
@Component
public class InitDictListener implements InitializingBean, ServletContextAware {
    @Autowired
    private DictService dictService;
    @Autowired
    private RedisService redisService;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {

    }
}
