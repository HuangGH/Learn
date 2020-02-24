package com.learn.think.in.spring.ioc.contain;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.stream.Stream;

/**
 * @author hgh
 * @since 2020-02-07 19:16
 */
public class IoCContainDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        xmlBeanDefinitionReader.loadBeanDefinitions("/META-INF/dependency-injection-context.xml");

        Stream.of(defaultListableBeanFactory.getBeanDefinitionNames()).forEach(System.out::println);

    }
}
