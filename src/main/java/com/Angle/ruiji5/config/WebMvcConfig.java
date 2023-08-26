package com.Angle.ruiji5.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 功能描述
 *
 * @author: 启文
 * @date: 2023年08月24日 15:08
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backend/");
        registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
//  Ctrl + D 向下复制一行
//        registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
    }
}
