package com.lcj.eduService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author：LCJ
 * @Description：
 * @Date：Create in 14:59 2021/1/20 0020
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.lcj"})
public class EduApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EduApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}
