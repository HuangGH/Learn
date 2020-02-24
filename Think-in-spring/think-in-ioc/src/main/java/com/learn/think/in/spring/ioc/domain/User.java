package com.learn.think.in.spring.ioc.domain;

import lombok.Data;
import lombok.ToString;

/**
 * 用户实体类
 *
 * @author hgh
 * @since 2020-02-01 15:35
 */
@Data
@ToString
public class User {

    private Integer id;
    private String name;

}
