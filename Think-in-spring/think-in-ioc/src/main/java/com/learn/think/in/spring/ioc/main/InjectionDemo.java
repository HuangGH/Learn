package com.learn.think.in.spring.ioc.main;

import com.learn.think.in.spring.ioc.injection.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入例子
 *
 * @author hgh
 * @since 2020-02-03 17:47
 */
public class InjectionDemo {

    public static void main(String[] args) {
        // 配置XML文件
        // 启动spring上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
        UserRepository userRepository = beanFactory.getBean(UserRepository.class);
        //        (此代码报错,因为依赖查找和注入两个注入的源不同)
        //        beanFactory.getBean(BeanFactory.class);

        System.out.println(userRepository.getUsers());
        // 自动注入注入的是 org.springframework.beans.factory.support.DefaultListableBeanFactory, 注入容器内建bean
        System.out.println(userRepository.getBeanFactory() == beanFactory);
        System.out.println(userRepository.getObjectFactory().getObject() == beanFactory);
    }

}
