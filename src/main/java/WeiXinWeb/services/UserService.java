package WeiXinWeb.services;

import WeiXinWeb.mapper.UserMapper;
import WeiXinWeb.pojo.User;
import WeiXinWeb.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserService {
    //提到最上面，只用执行一次
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<User> selectAll()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = userMapper.selectAll();

        sqlSession.close();
        return users;
    }

}
