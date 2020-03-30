package cn.learn.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author hgh
 * @since 2020-03-02 22:18
 */
@Async
@Service
public class AsyncService {

    private final static Logger logger = LoggerFactory.getLogger(AsyncService.class);


    public void testAsync() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("async method");

    }
}
