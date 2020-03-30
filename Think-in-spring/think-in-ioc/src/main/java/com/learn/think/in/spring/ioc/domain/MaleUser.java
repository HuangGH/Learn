package com.learn.think.in.spring.ioc.domain;

import com.learn.think.in.spring.ioc.lookup.annotation.Male;
import lombok.Data;
import lombok.ToString;

/**
 * @author hgh
 * @since 2020-02-01 16:56
 */
@ToString(callSuper = true)
@Male
@Data
public class MaleUser extends User {

    private String sex;

}
