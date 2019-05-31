package bean.person;

import lombok.Builder;
import lombok.Data;

/**
 * @description 家庭地址
 * @date 2019-05-31 09:22
 * @author  hgh
 */
@Data
@Builder
public class Address {
    private String province;
    private String city;
    private String county;
}
