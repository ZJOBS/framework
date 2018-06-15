package zjobs.entity;

/**
 * 课程
 *
 * @author jiezhang
 */
public class Curriculum extends  BaseEntity{
    /**
     * 编号
     */
    private String id;
    /**
     * 课程名
     */
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
