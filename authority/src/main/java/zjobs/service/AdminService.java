package zjobs.service;

import zjobs.entity.DataTablePage;
import zjobs.entity.db.Admin;

import java.util.Map;

/**
 * 管理员服务接口
 *
 * @author jiezhang
 * @date 2015/3/10
 */
public interface AdminService extends BaseService<Admin, Exception> {
    public Admin login(Admin admin) throws Exception;
}
