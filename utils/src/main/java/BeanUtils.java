/**
 * @author hgh 2019-06-24 11:16
 */
public class BeanUtils {

    //    private final static Logger logger = LoggerFactory.getLogger(BeanUtils.class);
    //
    //    /**
    //     * 封装{@link org.springframework.beans.BeanUtils#copyProperties(Object, Object)}，直接将结果返回
    //     * <p>
    //     * RecordPersonalInfo recordPersonalInfo = new RecordPersonalInfo("username");
    //     * return BeanUtil.transform(RecordPersonalInfoDTO.class, recordPersonalInfo);
    //     * </p>
    //     */
    //    public static <T> T transfrom(Class<T> clazz, Object src) {
    //        if (src == null) {
    //            return null;
    //        }
    //        T instance = null;
    //        try {
    //            instance = clazz.newInstance();
    //        } catch (Exception e) {
    //            logger.error("instance object error", e);
    //        }
    //        org.springframework.beans.BeanUtils.copyProperties(src, instance, getNullPropertyNames(src));
    //        return instance;
    //    }
    //
    //    /**
    //     * 批量转换返回结果
    //     */
    //    public static <T> List<T> batchTransform(final Class<T> clazz, List<? extends Object> srcList) {
    //        if (CollectionUtils.isEmpty(srcList)) {
    //            return Collections.emptyList();
    //        }
    //
    //        List<T> result = new ArrayList<>(srcList.size());
    //        for (Object srcObject : srcList) {
    //            result.add(transfrom(clazz, srcObject));
    //        }
    //        return result;
    //    }
    //
    //
    //    private static String[] getNullPropertyNames(Object source) {
    //        final BeanWrapper src = new BeanWrapperImpl(source);
    //        PropertyDescriptor[] pds = src.getPropertyDescriptors();
    //        Set<String> emptyNames = new HashSet<>();
    //        for (PropertyDescriptor pd : pds) {
    //            Object srcValue = src.getPropertyValue(pd.getName());
    //            if (srcValue == null) {
    //                emptyNames.add(pd.getName());
    //            }
    //        }
    //        String[] result = new String[emptyNames.size()];
    //        return emptyNames.toArray(result);
    //    }

}
