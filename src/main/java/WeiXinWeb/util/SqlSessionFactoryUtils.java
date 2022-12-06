package WeiXinWeb.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {
//    为了只创建一次SqlSessionFactory  且提高代码复用性
    private static SqlSessionFactory sqlSessionFactory;


//    静态代码块 只创建一次
    static
    {
        try {
            //1、加载mybatis核心配置文件 获得工 厂  官网复制
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//调用方法 返回工厂对象 每次都是同一个对象
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

}
