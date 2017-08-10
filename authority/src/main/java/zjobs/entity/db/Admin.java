package zjobs.entity.db;

import org.apache.ibatis.type.IntegerTypeHandler;
import zjobs.entity.BaseEntity;
import javax.persistence.Id;

/**
 * Created by ZhangJie on 2016/2/14.
 */

public class Admin extends BaseEntity {
    @Id
    private String adminId;
    private String name;
    private String password;
    private String description;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
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
