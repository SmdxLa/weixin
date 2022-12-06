import WeiXinWeb.mapper.PointMapper;
import WeiXinWeb.pojo.Point;
import WeiXinWeb.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

public class SQLtest {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Test
    public void selectByName()
    {

//        String name = "测";
        String name = "修";

        SqlSession sqlSession = sqlSessionFactory.openSession();
        PointMapper pointMapper = sqlSession.getMapper(PointMapper.class);

        List<Point> points = pointMapper.selectPointByName(name);

        System.out.println(points);

        sqlSession.close();
    }

    @Test
    public void selectByCondition()
    {
        Point point = new Point();
//        point.setName("修");
//        point.setId(5);
//        point.setLatitude(1);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PointMapper pointMapper = sqlSession.getMapper(PointMapper.class);

        List<Point> points = pointMapper.selectPointByCondition(point);

        System.out.println(points);

        sqlSession.close();
    }

    @Test
    public void selectBySingle()
    {
        Point point = new Point();
//        point.setName("修");

        SqlSession sqlSession = sqlSessionFactory.openSession();
        PointMapper pointMapper = sqlSession.getMapper(PointMapper.class);

        List<Point> points = pointMapper.selectPointBySingle(point);

        System.out.println(points);

        sqlSession.close();

    }

    @Test
    public void addPoint() {
        Point point = new Point();
        String name = "1";
        double latitude = 2;
        double longitude = 3;
        point.setName(name);
        point.setLatitude(latitude);
        point.setLongitude(longitude);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        PointMapper pointMapper = sqlSession.getMapper(PointMapper.class);

        pointMapper.addPoint(point);
        //提交事务
        sqlSession.commit();

        sqlSession.close();

    }


}
