package WeiXinWeb.Web;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *其他资源
 * 以下都是查询、获取关于其他资源的方法（数据、资源）
 * 通用资源方法，调用方法直接获取资源
 * fileName:文件全名
 */
@WebServlet("/resources/*")
public class ResourcesServlet extends BaseServlet {

    public void getResource(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int len;
        FileInputStream fileInputStream = new FileInputStream(baseURL+req.getParameter("fileName"));
        ServletOutputStream outputStream = resp.getOutputStream();

        setContentTypeByFileName(resp,req.getParameter("fileName"));

        try {
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
