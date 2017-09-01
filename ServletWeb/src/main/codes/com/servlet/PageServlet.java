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
import java.util.List;

@WebServlet("/pages")
public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNumberStr = req.getParameter("pageNumber");
        int pageNumber = 1;
        if (pageNumberStr!=null&&!pageNumberStr.isEmpty()){
            pageNumber=Integer.parseInt(pageNumberStr);
        }
        try {
            //分页的大小
            int pageSize =5;
            //利用数据库进行数据的总数统计
            int totalPosts = DAOFactory.getIUserDao().SelectPageNumbers();
            //计算得出的总页数
            int totalPages = totalPosts/pageSize + ((totalPosts%pageSize)>0?1:0);
            req.setAttribute("pageSize", pageSize);
            req.setAttribute("totalPosts", totalPosts);
            req.setAttribute("pageNumber", pageNumber);
            req.setAttribute("totalPages", totalPages);
            List<Users> PageList = DAOFactory.getIUserDao().SelectPageUser(pageNumber,pageSize);
            req.setAttribute("PageList",PageList);
            req.getRequestDispatcher("/jsp/index_page.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
