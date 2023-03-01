package WeiXinWeb.Web;

import WeiXinWeb.pojo.Tip;
import WeiXinWeb.services.TipService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/tip/*")
public class TipServlet extends BaseServlet{
    TipService TipService = new TipService();

    public void selectAllTips(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<Tip> Tips = TipService.selectAllTips();

        //一定要先设置编码 再获取Writer
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String userJson = JSON.toJSONString(Tips);

        writer.print(userJson);
    }

    public void addTip(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");

        Tip tip = getInfo(req, resp);

        TipService.addTip(tip);

        //一定要先设置编码 再获取Writer
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        writer.print("成功添加:" + tip.toString());
    }



    public Tip getInfo(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
    {
        Tip tip = new Tip();

        if((req.getParameter("id"))!=null)
        {
            int id = Integer.parseInt(req.getParameter("id"));
            tip.setId(id);
        }

        if((req.getParameter("tip"))!=null)
        {
            String tipMessage = req.getParameter("tip");
            tip.setTip(tipMessage);
        }
            return tip;
    }

}
