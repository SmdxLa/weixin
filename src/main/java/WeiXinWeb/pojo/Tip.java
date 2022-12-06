package WeiXinWeb.pojo;

public class Tip {
    private int id;
    private String tip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Tip{" +
                "id=" + id +
                ", tip='" + tip + '\'' +
                '}';
    }
}
