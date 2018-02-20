package zjobs.service.impl;

import org.springframework.stereotype.Service;
import zjobs.dao.AdminRoleDao;
import zjobs.entity.db.Admin;
import zjobs.entity.db.AdminRole;
import zjobs.entity.db.Role;
import zjobs.service.AbstractBindAndNotBindService;
import zjobs.service.AbstractService;
import zjobs.service.AdminRoleService;

/**
 * 用户角色服务实现类
 *
 * @author jiezhang
 * @date 2017/12/16
 */
@Service
public class AdminRoleServiceImpl extends AbstractBindAndNotBindService<Role, AdminRole, AdminRoleDao, Exception> implements AdminRoleService {

}
