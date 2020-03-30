package cn.learn.async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hgh
 * @since 2020-03-02 22:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AsyncConfig.class)

public class AsyncServiceTest {
    private final static Logger logger = LoggerFactory.getLogger(AsyncServiceTest.class);
    @Autowired
    AsyncService asyncService;

    @Test
    public void asyncService() throws InterruptedException {
        logger.info("start......");
        asyncService.testAsync();
        logger.info("end......");
        Thread.sleep(5000);

    }
}
