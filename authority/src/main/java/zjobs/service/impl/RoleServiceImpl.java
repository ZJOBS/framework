package zjobs.service.impl;

import org.springframework.stereotype.Service;
import zjobs.dao.RoleDao;
import zjobs.entity.db.Role;
import zjobs.service.AbstractService;
import zjobs.service.RoleService;

/**
 * Created by jiezhang on 2017/6/15.
 */
@Service
public class RoleServiceImpl extends AbstractService<Role, RoleDao> implements RoleService {
}
