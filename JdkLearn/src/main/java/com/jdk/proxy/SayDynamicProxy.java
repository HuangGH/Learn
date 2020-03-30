package com.jdk.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hgh
 * @since 2020-02-27 23:08
 */
@Slf4j
public class SayDynamicProxy implements InvocationHandler {

    private Object target;

    public SayDynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("Dynamic before invoke....");
        method.invoke(target, args);
        log.info("Dynamic after invoke....");
        return null;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
