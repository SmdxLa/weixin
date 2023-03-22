package WeiXinWeb.Web;


import WeiXinWeb.pojo.PointImage;
import WeiXinWeb.services.PointImageService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *图片资源
 * 以下都是查询、获取关于图片资源的方法（数据、资源）
 */
@WebServlet("/image/*")
public class imageResourcesServlet extends BaseServlet {
    /**
     * 1、点位图片资源：查询、获取
     */
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

        PointImage pointImage = getPointImageInfo(req,resp);

        PointImage Image = pointImageService.selectPointImageByName(pointImage.getName());

        //一定要先设置编码 再获取Writer
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String userJson = JSON.toJSONString(Image);

//        粗略展示
        writer.print(userJson);
    }

    public void showPointImageByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        PointImage pointImage = getPointImageInfo(req,resp);

        PointImage Image = pointImageService.selectPointImageByName(pointImage.getName());

        File file = new File(baseURL+Image.getUrl());

        try {

            FileInputStream fileInputStream = new FileInputStream(file);

            ServletOutputStream outputStream = resp.getOutputStream();

            resp.setContentType("image/jpg");

            int len;
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

    public void showPointImage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        PointImage pointImage = getPointImageInfo(req,resp);

        File file = new File(baseURL+pointImage.getUrl());

        try {

            FileInputStream fileInputStream = new FileInputStream(file);

            ServletOutputStream outputStream = resp.getOutputStream();

            resp.setContentType("image/jpg");

            int len;
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

    public PointImage getPointImageInfo(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
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

    /**
     * 2.普通图片资源：获取
     */
    public void getImage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int len;

        FileInputStream fileInputStream = new FileInputStream(baseURL + req.getParameter("fileName"));
        ServletOutputStream outputStream = resp.getOutputStream();


        setContentTypeByFileName(resp, req.getParameter("fileName"));

        try {
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
                outputStream.flush();
            }

            //关闭资源
            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//多张图片，未实现
    public void getImages(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int len;
        File file;
        FileInputStream fileInputStream;
        ServletOutputStream outputStream = resp.getOutputStream();

        resp.setContentType("image/jpg");
//        String imageUrl[]=req.getParameterValues("points.url");
        String imageUrl[]=req.getParameterValues("url");

        for (int i = 0; i < imageUrl.length; i++) {
            try {

                file = new File(baseURL+ imageUrl[i]);
                fileInputStream = new FileInputStream(file);

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
    }


    //    设置响应类型的方法
    public void setContentTypeByFileName(HttpServletResponse resp, String fileName) {
        String[] nameParts = fileName.split("\\.");
        String fileExtension = nameParts[nameParts.length - 1];
        String contentType;

        switch (fileExtension) {
            case "jpg":
            case "jpeg":
                contentType = "image/jpeg";
                break;
            case "png":
                contentType = "image/png";
                break;
            case "gif":
                contentType = "image/gif";
                break;
            case "pdf":
                contentType = "application/pdf";
                break;
            case "doc":
            case "docx":
                contentType = "application/msword";
                break;
            case "xls":
            case "xlsx":
                contentType = "application/vnd.ms-excel";
                break;
            default:
                contentType = "application/octet-stream";
        }

        resp.setContentType(contentType);
    }


}
