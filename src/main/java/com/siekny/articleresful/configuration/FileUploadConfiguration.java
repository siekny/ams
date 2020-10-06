package com.siekny.articleresful.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileUploadConfiguration implements WebMvcConfigurer {
    @Value("${file.image.path}")
    String path;

    @Value("${file.image.client}")
    String client;

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(path + "*").addResourceLocations(client);
    }
}
