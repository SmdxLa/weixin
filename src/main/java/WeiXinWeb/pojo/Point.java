package WeiXinWeb.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class Point {

    @JSONField(ordinal = 0)
    private int id;
    @JSONField(ordinal = 1)
    private String name;
    @JSONField(ordinal = 3)
    private double latitude;
    @JSONField(ordinal = 4)
    private  double longitude;
    @JSONField(ordinal = 5)
    private String url;

    public Point() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", url='" + url + '\'' +
                '}';
    }
}
