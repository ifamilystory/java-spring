package com.lingcloud.spring.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName="UserFilter",urlPatterns={"/*"})
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("执行了UserFilter的init()方法...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("执行了UserFilter的doFilter()方法...");
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        System.out.println("执行了UserFilter的destroy()方法...");
    }
}
