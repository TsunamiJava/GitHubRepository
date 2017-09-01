package test.serlvet;

import com.dao.factory.DAOFactory;
import com.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by CodingTest on 2017/8/2.
 */
public class TestOutLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path="/Test/TestIndex.jsp";
//        try {
//            List<Users> usersList = DAOFactory.getIUserDao().SelectAllUser();
//            req.setAttribute("datas",usersList);
//            usersList.forEach(System.out::println);
//            req.getRequestDispatcher(path).forward(req,resp);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        String str="aaaaaa";
        req.setAttribute("strs",str);
        req.getRequestDispatcher("/Test/TestIndex.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
