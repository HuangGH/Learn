package com.think.in.spring.bean.bean.init;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author hgh
 * @since 2020-02-15 17:19
 */
public class AutowireCapableBeanFactoryDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(AutowireCapableBeanFactoryDemo.class);
        annotationConfigApplicationContext.refresh();


    }

    @Bean(initMethod = "initMethod")
    public Student student() {
        return new Student();
    }
}
