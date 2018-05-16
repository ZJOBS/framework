package zjobs.dao;

import zjobs.entity.DataTablePage;
import zjobs.entity.db.Admin;

import java.util.List;

/**
 * 管理员数据处理接口
 *
 * @author jiezhang
 * @date 2017/3/14
 */
public interface AdminDao extends BaseDao<Admin, Exception> {

    /**
     * 查询所有管理员
     *
     * @return
     */
    public List<Admin> selectAll();
}
