package com.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    String path="/jsp/userLogin.jsp";
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request= (HttpServletRequest) servletRequest;
//        HttpServletResponse response= (HttpServletResponse) servletResponse;
//        HttpSession session=request.getSession(false);
//
//        String pathURL=request.getRequestURI();
//        System.out.println(pathURL);
//
//        String name= (String) session.getAttribute("username");
//        System.out.println(name);
//
//        System.out.println(pathURL.indexOf(path));
//        if (pathURL.indexOf(path)>-1){
//            filterChain.doFilter(request,response);
//            return;
//        }
//
//        if (name==null||"".equals(name)){
//            response.sendRedirect(path);
//        }else {
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpSession session=request.getSession();
        String name= (String) session.getAttribute("username");
        System.out.println(name);
        filterChain.doFilter(servletRequest,servletResponse);
    }
    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
}
