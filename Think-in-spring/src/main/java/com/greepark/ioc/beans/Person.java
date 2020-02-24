package com.greepark.ioc.beans;

/**
 * 简单的javaBean
 * {@link java.beans.BeanInfo}
 *
 * @author hgh
 * @since 2020-01-30 12:21
 */
public class Person {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
