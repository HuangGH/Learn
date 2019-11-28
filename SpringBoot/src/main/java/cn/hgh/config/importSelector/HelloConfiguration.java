package cn.hgh.config.importSelector;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Import;

/**
 * @author hgh 2019-09-04 11:47
 */
@Configurable
@Import(HelloImportSelector.class)
public class HelloConfiguration {

}
