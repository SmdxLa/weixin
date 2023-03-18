package WeiXinWeb.mapper;

import WeiXinWeb.pojo.Point;

import java.util.List;

public interface PointMapper {

    //查询全部
    List<Point> selectAllPoints();

    //    动态查询
    List<Point> selectPointByConditions(Point point);

    List<Point> selectPointByName(String name);

    List<Point> selectPointBySingle(Point point);

    void updatePoint(Point point);

//    添加
    void addPoint(Point point);

//    删除
    void deletePointByName(String name);


}
