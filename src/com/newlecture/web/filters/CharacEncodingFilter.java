package com.newlecture.web.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacEncodingFilter implements Filter {

	public void destroy() {
	}

// Servlet Container과 Servlet 사이에 필터 .
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
