package bean.person;

import lombok.Data;

/**
 * @description person实体
 * @date 2019-05-31 09:17
 * @author by hgh
 */
@Data
public class Person {

    private String name;
    private Integer age;
    private Address address;

    public void getall() {
        return;
    }

}
