package WeiXinWeb.Web;

import WeiXinWeb.pojo.User;
import WeiXinWeb.services.UserService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

      UserService userService = new UserService();

      public void selectAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
      {
           List<User> users = userService.selectAll();

           //一定要先设置编码 再获取Writer
           resp.setContentType("text/html;charset=utf-8");
           PrintWriter writer = resp.getWriter();

           String userJson = JSON.toJSONString(users);
           writer.print(userJson);
      }

}
