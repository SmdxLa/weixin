package WeiXinWeb.services;

import WeiXinWeb.mapper.PointImageMapper;
import WeiXinWeb.pojo.PointImage;
import WeiXinWeb.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PointImageService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<PointImage> selectAllPointImages()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PointImageMapper pointImagesMapper = sqlSession.getMapper(PointImageMapper.class);

        List<PointImage> pointImages = pointImagesMapper.selectAllPointImages();

        sqlSession.close();

        return  pointImages;
    }

    public PointImage selectPointImageByName(PointImage pointImage)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PointImageMapper pointImagesMapper = sqlSession.getMapper(PointImageMapper.class);

        PointImage Image = pointImagesMapper.selectPointImageByName(pointImage);

        sqlSession.close();

        return Image;
    }



}
