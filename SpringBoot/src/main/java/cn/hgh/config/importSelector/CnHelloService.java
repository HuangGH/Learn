package cn.hgh.config.importSelector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hgh 2019-09-04 11:45
 */
public class CnHelloService implements HelloService {

    private final static Logger logger = LoggerFactory.getLogger(CnHelloService.class);

    @Override
    public void sayHello() {
        logger.info("你好");
        logger.debug("你好");
    }
}
