package com.servlet;

import com.dao.factory.DAOFactory;
import com.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by CodingTest on 2017/8/2.
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        username=new String(username.getBytes("ISO-8859-1"),"UTF-8");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        Users users=new Users(username,password,email,phone);
        try {
            if (DAOFactory.getIUserDao().Register(users)){
                req.getRequestDispatcher("/jsp/userLogin.jsp").forward(req,resp);
            }else {
                req.getRequestDispatcher("/jsp/userRegister.jsp").forward(req,resp);
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
