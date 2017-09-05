package com.tsunami.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by CodingTest on 2017/8/1.
 */
@WebServlet("/loginOut")
public class LoginOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //禁止创建session
        HttpSession session = req.getSession(false);
        //判断session是否为空
        if(session==null){
            resp.sendRedirect("jsp/Login/login.jsp");
        }
        //注销session
        session.removeAttribute("sessionuser");
        System.out.println("session注销！！");
        resp.sendRedirect("jsp/Login/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
