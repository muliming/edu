package com.lcj.eduService.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 * @Author：LCJ
 * @Description：
 * @Date：Create in 15:01 2021/1/20 0020
 */
@Configuration
@MapperScan("com.lcj.eduService.mapper")
public class EduMyBatisPageConfig {

    //逻辑删除插件
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }

    /** * 分页插件 */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
