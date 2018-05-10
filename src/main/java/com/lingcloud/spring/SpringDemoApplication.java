package com.lingcloud.spring;

import com.lingcloud.spring.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan //注意别忘了   过滤器和监听器需要  配置完过在滤器后要springboot的入口类加入注解  //通过@ServletComponentScan自动扫描@WebServlet, @WebFilter, @WebListener
public class SpringDemoApplication extends SpringBootServletInitializer {
    /*我们需要类似于web.xml的配置方式来启动spring上下文了，在Application类的同级添加一个SpringBootStartApplication类，其代码如下:
    /**
     * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringDemoApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }
}
