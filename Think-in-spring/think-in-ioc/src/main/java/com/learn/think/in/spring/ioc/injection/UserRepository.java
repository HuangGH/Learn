package com.learn.think.in.spring.ioc.injection;

import com.learn.think.in.spring.ioc.domain.User;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;
import java.util.Date;


/**
 * @author hgh
 * @since 2020-02-03 17:48
 */
@ToString
@Data
public class UserRepository {

    private Collection<User> users;

    private ApplicationContext beanFactory;

    private ObjectFactory<ApplicationContext> objectFactory;

    private Date date;


}
