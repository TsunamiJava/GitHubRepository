package com.tsunami.ssm.tools.filer;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/*")
public class translateFilter implements Filter  {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("tsunami", httpServletRequest.getContextPath());
		//System.out.println("SystemFilter.doFilter");
		chain.doFilter(httpServletRequest, httpServletResponse);
	}

	public void init(FilterConfig config) throws ServletException {

	}
}
