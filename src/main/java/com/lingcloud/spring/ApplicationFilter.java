package com.lingcloud.spring;

import org.apache.tomcat.util.buf.Utf8Decoder;
import org.apache.tomcat.util.buf.Utf8Encoder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName="ApplicationFilter",urlPatterns={"/user/*"})
public class ApplicationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("执行了Filter的init()方法...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("执行了Filter的doFilter()方法...");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("执行了Filter的destroy()方法...");
    }
}
