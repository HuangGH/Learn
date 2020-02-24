package com.think.in.spring.bean.bean.definition;

import com.learn.think.in.spring.ioc.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author hgh
 * @since 2020-02-10 15:38
 */
public class BeanDefinitionDemo {

    public static void main(String[] args) {
        // 1通过beanDefinitionBuilder构造
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 通过属性设置
        beanDefinitionBuilder.addPropertyValue("id", 1);
        beanDefinitionBuilder.addPropertyValue("name", "hgh");
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        System.out.println(beanDefinition);

        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.add("id", 1);

        mutablePropertyValues.add("id", 1)
                             .add("name", "hgh");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);

    }
}
