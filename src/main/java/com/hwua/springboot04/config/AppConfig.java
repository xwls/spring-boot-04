package com.hwua.springboot04.config;

import com.hwua.springboot04.util.LoginInterceptor;
import com.hwua.springboot04.util.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AppConfig {

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
//                配置视图映射
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/main").setViewName("main");
                registry.addViewController("/list").setViewName("list");
                registry.addViewController("/hello").setViewName("hello");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor())
                        //拦截路径
                        .addPathPatterns("/**")
                        //排除路径
                        .excludePathPatterns("/login","/doLogin");
            }
        };
        return webMvcConfigurerAdapter;
    }


}
