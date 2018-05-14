package zjobs.entity.db;

import zjobs.annotation.ForeignTableId;
import zjobs.annotation.PrimaryTableId;
import zjobs.entity.BaseEntity;

import javax.persistence.Id;

/**
 * 角色菜单表实体类
 *
 * @author ZhangJie
 * @date 2017/12/16
 */
public class RoleMenu extends BaseEntity {
    @Id
    private String roleMenuId;
    @PrimaryTableId
    private String roleId;
    @ForeignTableId
    private String menuId;

    public String getRoleMenuId() {
        return roleMenuId;
    }

    public void setRoleMenuId(String roleMenuId) {
        this.roleMenuId = roleMenuId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
                "menuId='" + menuId + '\'' +
                ", createUserName='" + createUserName + '\'' +
                ", updateUserName='" + updateUserName + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", sequence=" + sequence +
                ", createDateStr='" + createDateStr + '\'' +
                ", updateDateStr='" + updateDateStr + '\'' +
                ", state='" + state + '\'' +
                ", activating=" + activating +
                '}';
    }
}
