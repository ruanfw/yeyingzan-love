package com.rfw.yeyingzan.love;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class YeyingzanLoveApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(YeyingzanLoveApplication.class);
    }

    public static void main(final String[] args) {
        SpringApplication.run(YeyingzanLoveApplication.class, args);
    }

}
