package zjobs.entity.db;

import zjobs.entity.BaseEntity;

import javax.persistence.Id;

/**
 * Created by jiezhang on 2017/6/13.
 */
public class Menu extends BaseEntity {
    @Id
    private String menuId;
    private String parentId;
    private String name;
    private String url;
    private Boolean leaf;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }


    @Override
    public String toString() {
        return "Menu{" +
                "menuId='" + menuId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", leaf=" + leaf +
                ", id='" + id + '\'' +
                ", createUserName='" + createUserName + '\'' +
                ", updateUserName='" + updateUserName + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", sequence=" + sequence +
                ", createDateStr='" + createDateStr + '\'' +
                ", updateDateStr='" + updateDateStr + '\'' +
                ", state=" + state +
                ", activating=" + activating +
                '}';
    }
}
