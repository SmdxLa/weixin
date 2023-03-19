package WeiXinWeb.Web;

import WeiXinWeb.pojo.PointImage;
import WeiXinWeb.services.PointImageService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;


@WebServlet("/pointImage/*")
public class PointImageServlet extends BaseServlet{
    PointImageService pointImageService = new PointImageService();

    public void selectAllPointImages(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<PointImage> pointImages = pointImageService.selectAllPointImages();

        //一定要先设置编码 再获取Writer
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String userJson = JSON.toJSONString(pointImages);

//        粗略展示
        writer.print(userJson);
    }

    public void selectPointImageByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        PointImage pointImage = getInfo(req,resp);

        PointImage Image = pointImageService.selectPointImageByName(pointImage);

        //一定要先设置编码 再获取Writer
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String userJson = JSON.toJSONString(Image);

//        粗略展示
        writer.print(userJson);
    }




    public void showPointImages(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        PointImage pointImage = getInfo(req,resp);

        PointImage Image = pointImageService.selectPointImageByName(pointImage);

        File file = new File(imageBaseURL+"OIP.jpg");

        try {

            FileInputStream fileInputStream = new FileInputStream(
                    file);

            ServletOutputStream outputStream = resp.getOutputStream();

            resp.setContentType("image/jpg");

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len=fileInputStream.read(bytes)) !=-1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }

            //关闭资源
            outputStream.close();
            fileInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public PointImage getInfo(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
    {
        PointImage pointImage = new PointImage();

        if((req.getParameter("name"))!=null)
        {
            String name = req.getParameter("name");
            pointImage.setName(name);
        }

        if(req.getParameter("url")!=null){
            String url = req.getParameter("url");
            pointImage.setUrl(url);
        }

        return pointImage;
    }
}
