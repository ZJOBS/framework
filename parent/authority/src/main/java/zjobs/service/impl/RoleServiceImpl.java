package zjobs.service.impl;

import org.springframework.stereotype.Service;
import zjobs.dao.RoleDao;
import zjobs.entity.DataTablePage;
import zjobs.entity.db.Role;
import zjobs.service.AbstractService;
import zjobs.service.RoleService;

import java.util.List;
import java.util.Map;

/**
 * 角色服务实现类
 *
 * @author jiezhang
 * @date 2017/6/15
 */
@Service
public class RoleServiceImpl extends AbstractService<Role, RoleDao> implements RoleService {
    //@Override
//    public DataTablePage queryBindPage(Map parameters, DataTablePage page) throws Exception {
//        page.setParams(parameters);
//        List<Role> list = dao.queryDataTablePage(page);
//        page.setAaData(list);
//        return null;
//    }

    //@Override
//    public DataTablePage queryUnbindPage(Map parameters, DataTablePage page) throws Exception {
//        return null;
//    }
}
