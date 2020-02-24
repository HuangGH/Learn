import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 对Dozer的封装,支持对象拷贝时候 enum to enum， enum to string , string to enum
 *
 * @author hgh 2019-06-28 17:09
 */
public class DozerUtils {

    private static final Mapper MAPPER = DozerBeanMapperBuilder.buildDefault();

    /**
     * 单个对象转换
     */
    public static <T> T transform(Class<T> destinationClass, Object source) {
        if (source == null) {
            return null;
        }
        return MAPPER.map(source, destinationClass);
    }


    /**
     * 两个对象合并成一个
     */
    public static <T> T transform(Class<T> destinationClass, Object major, Object secondary) {
        T result = null;
        try {
            result = destinationClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (major == null || result == null) {
            return null;
        }
        if (secondary != null) {
            MAPPER.map(secondary, result);
        }
        if (major != null) {
            MAPPER.map(major, result);
        }
        return result;
    }


    /**
     * 批量转换返回结果
     */
    public static <T> List<T> batchTransform(final Class<T> clazz, List srcList) {

        if (CollectionUtils.isEmpty(srcList)) {
            return Collections.emptyList();
        }
        List<T> result = new ArrayList<>(srcList.size());
        for (Object srcObject : srcList) {
            result.add(transform(clazz, srcObject));
        }
        return result;
    }


}
