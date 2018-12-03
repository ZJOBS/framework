package zjobs.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 全局的数据
 *
 * @author jiezhang
 * @date 2017/6/15
 */
public class Application implements ServletContextListener {

    /**
     * Spring应用上下文环境
     */
    private static ServletContext applicationContext;


    public static ServletContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        applicationContext = sce.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
