package com.lingcloud.spring;

import com.lingcloud.spring.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//通过@ServletComponentScan自动扫描@WebServlet, @WebFilter, @WebListener
@ServletComponentScan //注意别忘了   过滤器和监听器需要  配置完过在滤器后要springboot的入口类加入注解
public class SpringDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }
}
