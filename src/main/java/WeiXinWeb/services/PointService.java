package WeiXinWeb.services;

import WeiXinWeb.mapper.PointMapper;
import WeiXinWeb.pojo.Point;
import WeiXinWeb.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PointService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();


//    查询所有点
    public List<Point> selectAllPoints()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PointMapper pointMapper = sqlSession.getMapper(PointMapper.class);

        List<Point> points = pointMapper.selectAllPoints();

        sqlSession.close();

        return  points;
    }

//      用名字查询
    public List<Point> selectPointByName(String name)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PointMapper pointMapper = sqlSession.getMapper(PointMapper.class);

        List<Point> points = pointMapper.selectPointByName(name);
        sqlSession.close();

        return points;

    }

    public List<Point> selectPointBySingle(Point point)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PointMapper pointMapper = sqlSession.getMapper(PointMapper.class);

        List<Point> points = pointMapper.selectPointBySingle(point);
        sqlSession.close();

        return points;
    }


    public List<Point> selectPointByCondition(Point point)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PointMapper pointMapper = sqlSession.getMapper(PointMapper.class);

        List<Point> points = pointMapper.selectPointByConditions(point);
        sqlSession.close();

        return points;

    }

    public void updatePoint(Point point)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PointMapper pointMapper = sqlSession.getMapper(PointMapper.class);

        pointMapper.updatePoint(point);

        sqlSession.commit();
        sqlSession.close();
    }

//    添加数据
    public void addPoint(Point point)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PointMapper pointMapper = sqlSession.getMapper(PointMapper.class);

        pointMapper.addPoint(point);
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    public void deletePointByName(String name)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PointMapper pointMapper = sqlSession.getMapper(PointMapper.class);

        pointMapper.deletePointByName(name);
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }




}
