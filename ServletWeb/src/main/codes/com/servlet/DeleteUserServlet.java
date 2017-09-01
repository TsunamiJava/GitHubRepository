package com.servlet;

import com.dao.factory.DAOFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by CodingTest on 2017/8/3.
 */
@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr =req.getParameter("id");
        if (idStr!=null&&!idStr.equals("")){
            try {
                DAOFactory.getIUserDao().DeteleById(Integer.valueOf(idStr));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        req.getRequestDispatcher("showdatas").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
