package com.jdk.proxy;

import org.junit.Test;

import java.util.ArrayList;


/**
 * @author hgh
 * @since 2020-02-27 22:33
 */
public class CMain {
    /**
     * 测试JDK静态代理
     * JDK静态代理很容易就完成了对一个类的代理操作
     * 缺点:由于代理只能为一个类服务，如果需要代理的类很多，那么就需要编写大量的代理类，比较繁琐。
     */
    @Test
    public void testProxy() {
        ISay iSay = new ISayProxy();
        iSay.hello();
    }

    /**
     * 动态代理
     */
    @Test
    public void testDynamicProxy() {
        ISay iSay = new SayImpl();
        SayDynamicProxy sayDynamicProxy = new SayDynamicProxy(iSay);
        ISay iSay1 = (ISay) sayDynamicProxy.getProxy();
        iSay1.hello();
    }


    @Test
    public void testList() {
        ArrayList list = new ArrayList();
        list.add(3);
    }
}
