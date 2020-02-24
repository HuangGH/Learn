package com.think.in.spring.bean.bean.init;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @author hgh
 * @since 2020-02-15 18:09
 */
public class Student implements InitializingBean {

    @PostConstruct
    public void init() {
        System.out.println("init...");
    }

    public void initMethod() {
        System.out.println("initMethod...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean....");
    }
}
