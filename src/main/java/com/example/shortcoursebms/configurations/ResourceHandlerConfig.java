package com.example.shortcoursebms.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@PropertySource("classpath:/project_file.properties")
public class ResourceHandlerConfig implements WebMvcConfigurer {

    @Value("${server.path}")
    private String SERVER_PATH;

    @Value("${client.path}")
    private String CLIENT_PATH;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/static/**")
                .addResourceLocations("classpath:/static/");


        registry.addResourceHandler(CLIENT_PATH + "**")
                .addResourceLocations("file:" + SERVER_PATH);

        registry.addResourceHandler("/resources/alte/**")
                .addResourceLocations("classpath:/static/admin-lte/");


        registry.addResourceHandler("/swagger/**")
                .addResourceLocations("classpath:/static/swagger-v2.1.3/dist/");

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login-page")
                .setViewName("login/login-form");
    }
}
