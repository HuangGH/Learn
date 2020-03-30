package com.learn.think.in.spring.ioc.contain;

import com.learn.think.in.spring.ioc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.Map;

/**`
 * @author hgh
 * @since 2020-02-10 10:21
 */
public class AnnotationIoCDemo {


    @Autowired
    private User user;

    @Autowired
    private Map<String, User> userMap;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(AnnotationIoCDemo.class);

        annotationConfigApplicationContext.refresh();

        System.out.println(annotationConfigApplicationContext.getBeansOfType(User.class));

        Arrays.stream(annotationConfigApplicationContext.getBeanDefinitionNames()).forEach(System.out::println);

    }

    @Bean
    @Primary
    public User getUser() {
        User user = new User();
        user.setId(3);
        user.setName("hgh");
        return user;
    }

    @Bean
    public User getUser2() {
        User user = new User();
        user.setId(3);
        user.setName("hgh");
        return user;
    }

}
