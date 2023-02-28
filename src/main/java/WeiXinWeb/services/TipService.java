package WeiXinWeb.services;

import WeiXinWeb.mapper.TipMapper;
import WeiXinWeb.pojo.Tip;
import WeiXinWeb.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class TipService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Tip> selectAllTips()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TipMapper tipMapper = sqlSession.getMapper(TipMapper.class);
        List<Tip> tips = tipMapper.selectAllTips();

        sqlSession.close();

        return tips;
    }

    public void  addTip(Tip tip)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TipMapper tipMapper = sqlSession.getMapper(TipMapper.class);

        tipMapper.addTip(tip);

        sqlSession.close();
    }



}
