package zjobs.service;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import zjobs.dao.BaseBindAndNotBindDao;
import zjobs.entity.BaseEntity;
import zjobs.entity.DataTablePage;
import zjobs.utils.JsonUtil;

import java.util.*;

/**
 * 中间表绑定与未绑定抽象类
 *
 * @param <F>
 * @param <T>
 * @param <D> Dao
 * @param <E> 异常
 * @author jiezhang
 * @date 2018/02/09
 */
public abstract class AbstractBindAndNotBindService<F extends BaseEntity, T extends BaseEntity, D extends BaseBindAndNotBindDao<F, T, E>, E extends Exception> implements BaseBindAndNotBindService<F, T, E> {
    @Autowired
    protected D dao;

    @Autowired
    @Qualifier("snowflakeSequenceImpl")
    protected SequenceService sequenceService;

    public D getDao() {
        return dao;
    }

    public void setDao(D dao) {
        this.dao = dao;
    }

    @Override
    public DataTablePage queryBindDataTablePage(Map parameters, DataTablePage<F> page) throws Exception {
        page.setParams(parameters);
        List<F> list = dao.queryBindDataTablePage(page);
        page.setAaData(list);
        return page;
    }

    @Override
    public DataTablePage queryNotBindDataTablePage(Map parameters, DataTablePage<F> page) throws Exception {
        page.setParams(parameters);
        List<F> list = dao.queryNotBindDataTablePage(page);
        page.setAaData(list);
        return page;
    }

    @Override
    public int bind(List<T> list) throws Exception {
        List<T> insertList = new ArrayList<>(list.size());
        //防止出现一毫秒内重号
        Set<String> set = new HashSet<String>();
        while (true) {
            if (set.size() == list.size()) {
                break;
            } else {
                set.add(String.valueOf(sequenceService.getSequence()));
            }
        }
        List<String> seqList = new LinkedList<String>();
        seqList.addAll(set);
        for (int i = 0; i < list.size(); i++) {
            T entity = list.get(i);
            entity.putIdField(seqList.get(i));
        }
//        for (T entity : list) {
//            entity.putIdField(String.valueOf(sequenceService.getSequence()));
//        }
        return dao.insertList(list);
    }

    @Override
    public int unbind(Map parameter) throws Exception {
        return dao.removeList(parameter);
    }
}
