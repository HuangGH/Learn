package com.learn.think.in.spring.ioc.contain;

import com.learn.think.in.spring.ioc.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * @author hgh
 * @since 2020-02-10 10:21
 */
public class AnnotationIoCDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(AnnotationIoCDemo.class);

        annotationConfigApplicationContext.refresh();

        System.out.println(annotationConfigApplicationContext.getBeansOfType(User.class));
        Arrays.stream(annotationConfigApplicationContext.getBeanDefinitionNames()).forEach(System.out::println);

    }

    //    @Component
    public static class Config {

        @Bean(value = "hgh")
        public User getUser() {
            User user = new User();
            user.setId(3);
            user.setName("hgh");
            return user;
        }
    }

}
