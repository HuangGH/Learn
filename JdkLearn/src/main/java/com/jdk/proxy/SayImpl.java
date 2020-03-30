package com.jdk.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hgh
 * @since 2020-02-27 23:14
 */
@Slf4j
public class SayImpl implements ISay {
    @Override
    public void hello() {
        log.info("hello");
    }
}
