import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CodingTest on 2017/7/31.
 */
@WebServlet("/HelloForm")
public class HelloForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("name");
        String password=req.getParameter("password");

        if (password.equals("test")){
            Cookie name = new Cookie("name", URLEncoder.encode(username,"UTF-8"));
            Cookie passwords= new Cookie("url",password);

            name.setMaxAge(60*60*24);
            passwords.setMaxAge(60*60*24);

            resp.addCookie(name);
            resp.addCookie(passwords);

            HttpSession session=req.getSession(true);
            Date CreateTime = new Date(session.getCreationTime());
            Date lastAccessTime = new Date(session.getLastAccessedTime());
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Integer visitCount = new Integer(0);
            String visitCountKey = new String("visitCount");

            if(session.isNew()){
                session.setAttribute(username,password);
            }else{
                visitCount = (Integer)session.getAttribute(visitCountKey);
                visitCount = visitCount + 1;
                username = (String)session.getAttribute(password);
            }
            //session.setAttribute();
        }

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String title = "cookie";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>用户：</b>："
                + req.getParameter("name") + "\n</li>" +
                "  <li><b>密码：</b>："
                + req.getParameter("password") + "\n</li>" +
                "</ul>\n" +
                "</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

}
