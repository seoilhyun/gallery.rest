package com.gallery;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 1.
 * Time: 오전 11:09
 * To change this template use File | Settings | File Templates.
 */
@SpringBootApplication
public class AppConfig {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication();

        application.run(AppConfig.class);
    }

    @Bean
    public ModelMapper modelMapper (){
        return new ModelMapper();
    }
}
