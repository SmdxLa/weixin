package WeiXinWeb.Web;

import WeiXinWeb.pojo.Point;
import WeiXinWeb.services.PointService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/point/*")
public class PointServlet extends BaseServlet {

    PointService pointService = new PointService();

    public void selectAllPoints(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<Point> points = pointService.selectAllPoints();

        //一定要先设置编码 再获取Writer
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String userJson = JSON.toJSONString(points);

//        粗略展示
        writer.print(userJson);

    }

    public void selectPointByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
//        模拟接收到数据
        String name = req.getParameter("name");

        List<Point> points = pointService.selectPointByName(name);


        //一定要先设置编码 再获取Writer
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String userJson = JSON.toJSONString(points);
        writer.print(userJson);
    }

        public void selectPointByConditions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Point point = getInfo(req,resp);

        List<Point> points = pointService.selectPointByCondition(point);


        //一定要先设置编码 再获取Writer
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String userJson = JSON.toJSONString(points);
        writer.print(userJson);
    }

    public void  selectPointBySingle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Point point = getInfo(req,resp);

        List<Point> points = pointService.selectPointBySingle(point);

        //一定要先设置编码 再获取Writer
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String userJson = JSON.toJSONString(points);
        writer.print(userJson);
    }


    public void addPoint(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");

        Point point = getInfo(req,resp);

        pointService.addPoint(point);

        //一定要先设置编码 再获取Writer
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        writer.print("成功添加:" + point.toString());
    }

    public void updatePoint(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");

        Point point = getInfo(req,resp);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        pointService.updatePoint(point);

        writer.print("成功修改");
    }


    public void deletePointByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        pointService.deletePointByName(name);

        writer.print("成功删除");
    }


    public Point getInfo(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
    {
        Point point = new Point();
        if((req.getParameter("id"))!=null)
        {
            int id = Integer.parseInt(req.getParameter("id"));
            point.setId(id);
        }

        if((req.getParameter("name"))!=null)
        {
            String name = req.getParameter("name");
            point.setName(name);
        }

        if (req.getParameter("latitude")!=null) {
            double latitude = Double.parseDouble(req.getParameter("latitude")) ;
            point.setLatitude(latitude);
        }

        if (req.getParameter("longitude")!=null) {
            double longitude = Double.parseDouble(req.getParameter("longitude")) ;
            point.setLongitude(longitude);
        }

        if(req.getParameter("url")!=null){
            String url = req.getParameter("url");
            point.setUrl(url);
        }

        return point;
    }

}
