package com.servlet;

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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodingTest on 2017/8/2.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path="/jsp/userLogin.jsp";
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        List<String> info = new ArrayList<String>();
        if(username==null||"".equals(username)){
            info.add("用户id不能为空");
        }
        if (password==null||"".equals(password)){
            info.add("密码不能为空");
        }
        if (info.size()==0){
            Users users=new Users(username,password);
            try {
                if (DAOFactory.getIUserDao().UserIsNew(users)){
                    if (DAOFactory.getIUserDao().Login(users)){
                        //利用session获取数据
                        HttpSession session= req.getSession();
                        session.setAttribute("username",users.getUsername());
//                        //測試是否能存進sessions
//                        String string= (String) session.getAttribute("username");
//                        System.out.println(string);
//                        path="/jsp/userHeader.jsp";
                        path="/showdatas?search=";
                        req.getRequestDispatcher(path).forward(req,resp);
                        return;
                    }else {
                        info.add("密码错误！！");
                    }
                }else {
                    info.add("请输入正确的用户！！");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        req.setAttribute("info",info);
        //重定向到jsp
        req.getRequestDispatcher(path).forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
