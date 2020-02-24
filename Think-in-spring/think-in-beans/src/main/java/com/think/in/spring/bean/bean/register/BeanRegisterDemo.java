package com.think.in.spring.bean.bean.register;

import com.learn.think.in.spring.ioc.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author hgh
 * @since 2020-02-10 10:21
 */
//@Import(AnnotationIoCDemo.Config.class)
//@Configuration
public class BeanRegisterDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        // 第一种方式, 直接注册或引入配置类方式
        //        annotationConfigApplicationContext.register(AnnotationIoCDemo.Config.class);

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 2);
        beanDefinitionBuilder.addPropertyValue("name", "nice");

        // 第一种方式 命名方式:BeanDefinitionRegistry.registerBeanDefinition()
        annotationConfigApplicationContext.registerBeanDefinition("Nice", beanDefinitionBuilder.getBeanDefinition());
        // 第二种方式 非命名方式   BeanDefinitionReaderUtils.registerWithGeneratedName
        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), annotationConfigApplicationContext);

        // 第3种方式 @component 和scan
        annotationConfigApplicationContext.scan("com.think.in.spring.bean.bean.register");
        annotationConfigApplicationContext.refresh();
        System.out.println(annotationConfigApplicationContext.getBeansOfType(User.class));
    }

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
