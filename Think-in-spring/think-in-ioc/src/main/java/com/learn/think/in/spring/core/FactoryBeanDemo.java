package com.learn.think.in.spring.core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.Stream;

/**
 * @author hgh
 * @since 2020-02-05 23:59
 */
public class FactoryBeanDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/factory-bean-learn.xml");
        ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
        Stream.of(listableBeanFactory.getBeanDefinitionNames()).forEach(System.out::println);
        FactoryBeanService factoryBeanService = beanFactory.getBean(FactoryBeanService.class);
        factoryBeanService.testFactoryBean();
    }


}
