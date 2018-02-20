package zjobs.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import zjobs.Constant.BaseConstants;
import zjobs.dao.BaseDao;
import zjobs.entity.DataTablePage;
import zjobs.entity.Page;
import zjobs.entity.BaseEntity;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 抽象公共服务
 *
 * @author jiezhang
 * @date 2016/2/14
 */
public abstract class AbstractService<T extends BaseEntity, D extends BaseDao<T, Exception>> implements BaseService<T, Exception> {
    @Autowired
    protected D dao;

    @Autowired
    @Qualifier("snowflakeSequenceImpl")
    protected SequenceService sequenceService;


    @Resource(name = "taskExecutor")
    protected TaskExecutor taskExecutor;

//taskExecutor 使用方法见如下
//    try {
//        taskExecutor.execute(new Runnable() {
//            public void run() {
//                //这里编写处理业务代码
//
//            }
//        });
//    } catch (Exception e) {
//        e.printStackTrace();
//    }

    public D getDao() {
        return dao;
    }

    public void setDao(D dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int createEntity(T entity) throws Exception {
        long a = sequenceService.getSequence();
        entity.putIdField(String.valueOf(a));
        dao.insertEntity(entity.toMap());
        return Integer.parseInt("0");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int removeEntity(T entity) throws Exception {
        Object object = entity.gainKeyValue();
        if (object == null) {
            System.out.println("数据未null");
            throw new Exception("没有ID");
        }
        return dao.deleteEntity(entity.toMap());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int modifyEntity(T entity) throws Exception {
        return dao.updateEntity(entity.toMap());
    }

    @Override
    public T findEntity(T entity) throws Exception {
        return dao.selectEntity(entity.toMap());
    }

    @Override
    public DataTablePage queryPage(Map parameters, DataTablePage page) throws Exception {
        page.setParams(parameters);
        List<T> list = dao.queryDataTablePage(page);
        page.setAaData(list);
        return page;
    }

    @Override
    public int disable(T entity) throws Exception {
        entity.setState(BaseConstants.DISABLE);
        return modifyEntity(entity);
    }

    @Override
    public int enable(T entity) throws Exception {
        entity.setState(BaseConstants.ENABLE);
        return modifyEntity(entity);
    }
}
