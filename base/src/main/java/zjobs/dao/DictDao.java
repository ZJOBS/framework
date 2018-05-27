package zjobs.dao;

import zjobs.entity.db.Dict;

import java.util.List;

/**
 * 数据字典
 *
 * @author ZJOBS
 */
public interface DictDao extends BaseDao<Dict, Exception> {
    /**
     * 查询所有字典
     *
     * @return
     */
    public List<Dict> selectAll();
}
