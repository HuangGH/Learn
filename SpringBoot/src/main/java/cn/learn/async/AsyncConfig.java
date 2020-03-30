package cn.learn.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author hgh
 * @since 2020-03-02 21:51
 */
@Configuration
@EnableAsync
@ComponentScan
public class AsyncConfig implements AsyncConfigurer {
    @PostConstruct
    public void init() {

    }

    @Override
    public Executor getAsyncExecutor() {
        return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> {
            System.out.println(method);
        };
    }
}
