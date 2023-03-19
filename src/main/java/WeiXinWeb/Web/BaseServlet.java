package WeiXinWeb.Web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 根据请求最后一段路径，进行方法分发
 */
public class BaseServlet extends HttpServlet {

    public static String imageBaseURL = "/usr/local/resources/image/";
    public static String localBaseURL = "F:\\Java_Code\\WeiXin\\src\\main\\resources\\image\\";


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求路径 短路径uri
        String uri = req.getRequestURI();//JavaWebAll/...
        //获取最后一段路径的方法名
        int index = uri.lastIndexOf("/");
        String methodName = uri.substring(index + 1);//因为它包括/ 所以加1

        //执行方法：获取对应Servlet字节码对象
        Class<? extends BaseServlet> aClass = this.getClass();
        //获取方法名
        try {
            Method method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //执行方法
            method.invoke(this,req,resp);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
