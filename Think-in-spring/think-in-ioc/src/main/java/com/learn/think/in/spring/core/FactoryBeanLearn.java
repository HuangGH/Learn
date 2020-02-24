package com.learn.think.in.spring.core;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author hgh
 * @since 2020-02-05 23:50
 */
public class FactoryBeanLearn implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        //这个Bean是我们自己new的，这里我们就可以控制Bean的创建过程了
        return new FactoryBeanServiceImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return FactoryBeanService.class;
    }

}
