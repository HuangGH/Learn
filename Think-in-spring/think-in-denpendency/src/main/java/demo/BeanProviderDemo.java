package demo;

import com.learn.think.in.spring.ioc.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author hgh
 * @since 2020-02-15 19:28
 */
public class BeanProviderDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(BeanProviderDemo.class);
        annotationConfigApplicationContext.refresh();
        ObjectProvider<User> beanProvider = annotationConfigApplicationContext.getBeanProvider(User.class);
        System.out.println(beanProvider.getObject());
    }


    @Bean
    public User user() {
        User user = new User();
        user.setName("hgh");
        return user;
    }

}
