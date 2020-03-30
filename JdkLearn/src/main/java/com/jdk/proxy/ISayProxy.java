package com.jdk.proxy;


import lombok.extern.slf4j.Slf4j;

/**
 * JDK静态代理实例
 *
 * @author hgh
 * @since 2020-02-27 22:37
 */
@Slf4j
public class ISayProxy implements ISay {


    private ISay iSay = new SayStaticImpl();

    @Override
    public void hello() {
        log.info("before invoke Isay");
        iSay.hello();
        log.info("after invoke Isay");
        log.info("sadf{}", "nice", new Exception());

    }
}
