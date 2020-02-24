package com.jdk8.stream;

import lombok.Data;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * @author by hgh
 * @description java.util.optional
 * @date 2019-05-30 18:23
 */
public class OptionalTest {


    /**
     * ifPersent  如果不为空就执行操作
     */
    @Test
    public void testIfPersent() {
        Person person = new Person("小明", 20);
        Optional<Person> personOption = Optional.ofNullable(person);
        if (personOption.isPresent()) {
            System.out.println(personOption.get());
        }
        // 上面代码跟 persin != null 的用法没什么区别，正确的使用如下
        System.out.println("----------我是分割线------------");
        personOption.ifPresent(System.out::println);
    }

    @Test
    public String convertTest() {
        Person person = new Person("小明", 20);
        //        if (person != null  && person.getName() != null) {
        //            return person.getName();
        //        } else {
        //            return "undefined";
        //        }
        System.out.println("----------我是分割线------------");
        return Optional.ofNullable(person).map(Person::getName).orElse("null");
    }

    @Test
    public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
        String text = null;

        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);

        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
    }

    @Test
    public void convertTest2() {
        List<String> collected = new ArrayList<>();
        collected.add("alpha");
        collected.add("beta");
        collected = collected.stream().map(String::toUpperCase).collect(Collectors.toList());//注意发生的变化
        System.out.println(collected);
    }

    @Test
    public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
        String text = "Text present";

        System.out.println("Using orElseGet:");
        String defaultText
                = Optional.ofNullable(text).orElseGet(this::getMyDefault);

        System.out.println("Using orElse:");
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
    }

    public String getMyDefault() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }

    /**
     * person实体,
     */
    @Data
    @ToString
    class Person {

        private String name;
        private int age;

        public Person() {

        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }
}
