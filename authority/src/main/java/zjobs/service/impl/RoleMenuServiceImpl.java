package zjobs.service.impl;

import org.springframework.stereotype.Service;
import zjobs.dao.RoleMenuDao;
import zjobs.entity.db.Menu;
import zjobs.entity.db.RoleMenu;
import zjobs.service.AbstractBindAndNotBindService;
import zjobs.service.RoleMenuService;

/**
 * 角色菜单服务实现类
 *
 * @author jiezhang
 */
@Service
public class RoleMenuServiceImpl extends AbstractBindAndNotBindService<Menu, RoleMenu, RoleMenuDao, Exception> implements RoleMenuService {
}
