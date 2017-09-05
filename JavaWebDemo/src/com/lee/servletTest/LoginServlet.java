package lee.servletTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by CodingTest on 2017/7/28.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // ����������ȡ
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("�û�����" + username);
        System.out.println("���룺" + password);

        System.out.println("----------------------------------------");

        // ���еĲ�����ȡ
        Map<String, String[]> map = req.getParameterMap();
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            System.out.println("key===>" + key + " ,value==>" + map.get(key)[0]);
        }

    }
}
