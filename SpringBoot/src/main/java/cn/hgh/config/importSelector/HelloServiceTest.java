package cn.hgh.config.importSelector;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author hgh 2019-09-04 11:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HelloConfiguration.class})
public class HelloServiceTest {

    private final static Logger logger = LoggerFactory.getLogger(HelloServiceTest.class);

    @Autowired
    private List<HelloService> helloServices;

    @Test
    public void test() {
        this.helloServices.forEach(HelloService::sayHello);
    }

}
