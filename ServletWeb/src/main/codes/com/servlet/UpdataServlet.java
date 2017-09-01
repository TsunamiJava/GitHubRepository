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
 * Created by CodingTest on 2017/8/4.
 */
@WebServlet("/updata")
public class UpdataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr!=null&&!idStr.equals("")){
            int id=Integer.valueOf(idStr);
            try {
                Users users= DAOFactory.getIUserDao().SelectById(id);
                req.setAttribute("users" ,users);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        req.getRequestDispatcher("/jsp/userUpdate.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String username = req.getParameter("username");
        String password= req.getParameter("password");
        String email = req.getParameter("email");
        String phone =req.getParameter("phone");
        Users users=new Users(Integer.valueOf(id),new String(username.getBytes("ISO-8859-1"),"UTF-8"),
                new String(password.getBytes("ISO-8859-1"),"UTF-8"),new String(email.getBytes("ISO-8859-1"),"UTF-8"),
                new String(phone.getBytes("ISO-8859-1"),"UTF-8"));
        try {
            DAOFactory.getIUserDao().UpdataById(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("showdatas").forward(req,resp);
    }
}
