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
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("username");
            username=new String(username.getBytes("ISO-8859-1"),"UTF-8");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");

            User user=new User(username,password,email,phone);

            DaoImplUser daoImplUser=new DaoImplUser();
            if(daoImplUser.Register(user).equals(true)){
                String url="../../../../../jsp/Login/login.jsp";
                url = new String(url.getBytes("UTF-8"),"ISO-8859-1");
                resp.sendRedirect(url);
            }else {
                String massage="注册失败...";
                req.setAttribute("message",massage);
                req.getRequestDispatcher("jsp/Login/Register.jsp").forward(req,resp);
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
