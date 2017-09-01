package test.serlvet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by CodingTest on 2017/8/2.
 */
public class TestCharEncodeingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
