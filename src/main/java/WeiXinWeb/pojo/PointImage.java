package WeiXinWeb.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class PointImage {
    @JSONField(ordinal = 0)
    private int id;
    @JSONField(ordinal = 1)
    private String name;
    @JSONField(ordinal = 2)
    private String url;       //文件路径


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "PointImage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
