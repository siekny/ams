package com.siekny.articleresful;

import com.siekny.articleresful.model.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@EnableConfigurationProperties({FileStorageProperties.class})

public class ArticleResfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleResfulApplication.class, args);
    }

}
