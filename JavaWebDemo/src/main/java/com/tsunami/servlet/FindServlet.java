package com.tsunami.servlet;

import com.tsunami.dao.daoImpl.DaoImplUser;
import com.tsunami.entity.User;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodingTest on 2017/8/1.
 */
public class FindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoImplUser daoImplUser=new DaoImplUser();
        try {
            List<User> list = daoImplUser.FindAllUser();
            req.setAttribute("list",list);
            req.getRequestDispatcher("Message.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Test
    public void test(){
        DaoImplUser daoImplUser=new DaoImplUser();
        try {
            System.out.println(daoImplUser.FindAllUser());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
