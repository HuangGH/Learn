package cn.learn.value;

import cn.learn.Application;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 测试@value和#value区别
 *
 * @author hgh
 * @since 2020-03-08 16:10
 */
@Component
@Data
@Slf4j
public class TestValueAnnotation {

    @Value("${name}")
    private String name;

    @Value(value = "#{@testValueAnnotation.getName()}")
    private String name2;

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        TestValueAnnotation bean = run.getBean(TestValueAnnotation.class);
        log.info(bean.getName());
        log.info(bean.getName2());
    }
}
