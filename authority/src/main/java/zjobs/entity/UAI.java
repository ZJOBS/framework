package zjobs.entity;

import zjobs.entity.db.Admin;

import java.io.Serializable;

/**
 * Created by ZhangJie on 2016/3/14.
 */
public class UAI implements Serializable {
    private String adminId;
    private String adminName;// 用户名
    private int roleId;// 角色Id
    private String roleName;// 角色名

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public void setAdmin(Admin admin) {
        this.adminId = admin.getAdminId();
        this.adminName = admin.getName();
    }

    @Override
    public String toString() {
        return "UAI{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
