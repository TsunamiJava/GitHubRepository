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

/**
 * Created by CodingTest on 2017/8/4.
 */
@WebServlet("/showdatas")
public class ShowDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Users> usersList = null;
        int pageNumber = 0;
        String pageNumberStr = req.getParameter("pageNumber");
        if (pageNumberStr!=null&&!pageNumberStr.isEmpty()){
            pageNumber=Integer.parseInt(pageNumberStr);
        }
        //分页的大小
        int pageSize =5;
        //利用数据库进行数据的总数统计
        int totalPosts = 0;
        //获取搜索框的内容
        String search=req.getParameter("search");
        //判断内容是否为空
        if (search != null && !search.equals("")) {
            try {
                //不为空时传入参数，进行数据库的查询
                usersList = DAOFactory.getIUserDao().SelectLIKEPageUser(search,pageNumber*pageSize,pageSize);
                //统计数据的总数
                totalPosts = DAOFactory.getIUserDao().SelectPageLIKENumbers(search);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            try {
                usersList = DAOFactory.getIUserDao().SelectPageUser(pageNumber * pageSize, pageSize);
                totalPosts = DAOFactory.getIUserDao().SelectPageNumbers();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //计算得出的总页数
        int totalPages = totalPosts/pageSize + ((totalPosts%pageSize)>0?1:0)-1;
        req.setAttribute("pageSize", pageSize);
        req.setAttribute("totalPosts", totalPosts);
        req.setAttribute("pageNumber", pageNumber);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("datas",usersList);
        req.setAttribute("search",search);
//        req.getRequestDispatcher("/jsp/index_page.jsp").forward(req,resp);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
