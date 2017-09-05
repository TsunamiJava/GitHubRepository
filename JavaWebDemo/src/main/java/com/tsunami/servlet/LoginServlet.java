package com.tsunami.servlet;

import com.tsunami.dao.daoImpl.DaoImplUser;
import com.tsunami.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by CodingTest on 2017/7/29.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String massage;
        User user=null;
        try {
            req.setCharacterEncoding("UTF-8");
            //获取表单的数据
            String username=req.getParameter("username");
            String password=req.getParameter("password");
            Cookie[] cookies=req.getCookies();

            //判断获取的数据是否为空
            if(username.equals(null)&&password.equals(null)){
                for (Cookie cookie : cookies){
                    if ("username".equals(cookie.getName())){
                        username=cookie.getValue();
                    }

                    if ("password".equals(cookie.getName())){
                        password=cookie.getValue();
                    }
                    user=new User(username,password);
                    req.getSession().setAttribute("sessionuser",user);
                    req.setAttribute("username",username);
                    req.getRequestDispatcher("jsp/Login/Message.jsp").forward(req,resp);
                }
            }else{
                //根据数据库的数据反馈判断是否登录成功
                if (new  DaoImplUser().Login(username,password).equals(false)){
                    //登录失败时返回登录界面
                    massage="请输入正确的账号和密码...";
                    req.setAttribute("message",massage);
                    req.getRequestDispatcher("jsp/Login/login.jsp").forward(req,resp);
                }else {
                    user=new User(username,password);
                    //利用session获取数据
                    req.getSession().setAttribute("sessionuser",user.getUsername());
                    req.setAttribute("username",username);

                    //Cookie记录成功登录的数据
                    Cookie cusername = new Cookie("username",username);
                    Cookie cpassword = new Cookie("password",password);
                    resp.addCookie(cusername);
                    resp.addCookie(cpassword);

                    req.getRequestDispatcher("jsp/Login/Message.jsp").forward(req,resp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
