package com.jdk8.stream;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author hgh
 * @description Stream learn
 * @date 2019-06-03 17:35
 */
public class StreamTest {

    @Test
    public void testsStream() {
        // 起始时间
        LocalTime start = LocalTime.now();

        List<Integer> list = new ArrayList<>();
        // 将10000-1存入list中
        for (int i = 100000; i >= 1; i--) {
            list.add(i);
        }

        list.stream()// 获取串行流
                .sorted()// 按自然排序，即按数字从小到大排序
                .count();// count()是终止操作，有终止操作才会执行中间操作sorted()

        // 终止时间
        LocalTime end = LocalTime.now();

        // 时间间隔
        Duration duration = Duration.between(start, end);
        // 输出时间间隔毫秒值
        System.out.println(duration.toMillis());
    }

    @Test
    public void testParallelStream() {
        // 起始时间
        LocalTime start = LocalTime.now();

        List<Integer> list = new ArrayList<>();
        // 将10000-1存入list中
        for (int i = 100000; i >= 1; i--) {
            list.add(i);
        }

        list.parallelStream()// 获取并行流
                .sorted()// 按自然排序，即按数字从小到大排序
                .count();// count()是终止操作，有终止操作才会执行中间操作sorted()

        // 终止时间
        LocalTime end = LocalTime.now();

        // 时间间隔
        Duration duration = Duration.between(start, end);
        // 输出时间间隔毫秒值
        System.out.println(duration.toMillis());
    }

    /**
     * 常见流的构造方法
     */
    @Test
    public void testStream() {
        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");
        // 2. Arrays
        String[] strArray = new String[]{"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);

    }

    public void toUppest() {
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());

    }


}
