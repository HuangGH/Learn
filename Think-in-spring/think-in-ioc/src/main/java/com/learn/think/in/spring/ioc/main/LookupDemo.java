package com.learn.think.in.spring.ioc.main;

import com.learn.think.in.spring.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

/**
 * 依赖查找例子
 *
 * @author hgh
 * @since 2020-02-01 15:42
 */
public class LookupDemo {

    public static void main(String[] args) {
        // 配置XML文件
        // 启动spring上下文
        // TODO: 2020-02-01 校验未配置id的name
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        // 实时查找
        findBeanInTime(beanFactory);
        // 延时查找
        findBeanLazyTime(beanFactory);
        // 根据Bean类型查找
        findBeanByType(beanFactory);
        // 根据Bean类型查找多个
        listBeanByType(beanFactory);
        // annotation
        listBeanByAnnotation(beanFactory);
    }

    /**
     * @param beanFactory 测试
     */
    private static void listBeanByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beans = (Map) listableBeanFactory.getBeansWithAnnotation(Component.class);
            System.out.println("根据annotation类型查找多个 : " + beans);
            System.out.println(Arrays.asList(listableBeanFactory.getBeanNamesForAnnotation(Component.class)));
        }
    }


    private static void listBeanByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beans = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("根据Bean类型查找多个 : " + beans);
        }
    }

    private static void findBeanByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("根据Bean类型查找：" + user);
    }

    // todo 存有疑惑
    private static void findBeanLazyTime(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延时查找：" + user);
    }

    private static void findBeanInTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean(User.class);
        System.out.println("实时查找 ：" + user);
    }
}
