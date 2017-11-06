package zjobs.service.impl;

import org.springframework.stereotype.Service;
import zjobs.dao.AdminDao;
import zjobs.entity.DataTablePage;
import zjobs.entity.db.Admin;
import zjobs.service.AbstractService;
import zjobs.service.AdminService;
import zjobs.utils.EncryptAndDecryptUtil;

import java.util.List;
import java.util.Map;

/**
 * 管理员方法
 * Created by ZJOBS on 2015/3/10.
 */
@Service
public class AdminServiceImpl extends AbstractService<Admin, AdminDao> implements AdminService {

    @Override
    public int createEntity(Admin entity) throws Exception {
        long a = sequenceService.getSequence();
        entity.setAdminId(String.valueOf(a));
        String encryptPassword = EncryptAndDecryptUtil.encrypt("111111");
        entity.setPassword(encryptPassword);
        entity.setCreateUserName(entity.getName());
        entity.setUpdateUserName(entity.getName());
        Admin odlUser = dao.selectEntity(entity.toMap());
        if (odlUser == null) {
            int isInsert = dao.insertEntity(entity.toMap());
            if (isInsert == 1) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public Admin login(Admin admin) throws Exception {
        String encryptPassword = EncryptAndDecryptUtil.encrypt(admin.getPassword());
        admin.setPassword(encryptPassword);
        admin = dao.selectEntity(admin.toMap());
        if (admin != null) {
            admin.setPassword(null);
        }
        return admin;
    }

    @Override
    public DataTablePage queryPage(Map parameters, DataTablePage page) throws Exception {
        page.setParams(parameters);
        List<Admin> list = dao.queryDataTablePage(page);
        page.setAaData(list);
        return page;
    }
}
