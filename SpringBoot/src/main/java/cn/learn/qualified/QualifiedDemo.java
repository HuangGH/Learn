package cn.learn.qualified;

import cn.learn.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.Collection;

import static java.lang.System.out;

/**
 * @author hgh
 * @since 2020-03-10 00:01
 */
public class QualifiedDemo {

    @Autowired
    private Collection<User> users;

    @Autowired
    @Qualifier
    private Collection<User> qualifierUser;

    @Resource
    private Collection<User> rootQualifierUser;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(QualifiedDemo.class);
        annotationConfigApplicationContext.refresh();
        QualifiedDemo bean = annotationConfigApplicationContext.getBean(QualifiedDemo.class);
        annotationConfigApplicationContext.getBeanProvider(User.class).stream().forEach(out::println);
        out.println(bean.users);
        out.println(bean.qualifierUser);
        out.println(bean.rootQualifierUser);

    }

    private static User createUser(long id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    @Bean
    public User user1() {
        return createUser(1);
    }

    @Bean
    public User user2() {
        return createUser(2);
    }

    @Bean
    @Qualifier
    public User user3() {
        return createUser(3);
    }

    @Bean
    @Qualifier("root")
    public User user4() {
        return createUser(4);
    }
}
