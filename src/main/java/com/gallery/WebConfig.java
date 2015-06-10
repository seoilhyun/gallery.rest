package com.gallery;

import com.gallery.web.controller.support.converter.LongTypeIdToEntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import javax.persistence.EntityManagerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: seoilhyun
 * Date: 2015. 6. 10.
 * Time: 오전 11:11
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(longTypeIdToEntityConverter());
    }

    @Bean
    public LongTypeIdToEntityConverter longTypeIdToEntityConverter() {
        return new LongTypeIdToEntityConverter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webContentInterceptor());

        InterceptorRegistration openEntityManagerInViewInterceptor = registry.addWebRequestInterceptor(openEntityManagerInViewInterceptor());
        openEntityManagerInViewInterceptor.addPathPatterns("/**");
    }


    @Bean
    public WebContentInterceptor webContentInterceptor() {
        WebContentInterceptor interceptor = new WebContentInterceptor();
        interceptor.setCacheSeconds(0);

        return interceptor;
    }

    @Bean
    public OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor() {
        OpenEntityManagerInViewInterceptor interceptor =  new OpenEntityManagerInViewInterceptor();
        interceptor.setEntityManagerFactory(entityManagerFactory);

        return interceptor;
    }

}