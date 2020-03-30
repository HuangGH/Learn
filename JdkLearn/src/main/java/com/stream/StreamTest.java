package com.stream;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * https://www.ibm.com/developerworks/cn/java/j-java8idioms11/index.html?ca=drs-
 *
 * @author hgh 2019-08-24 23:35
 */
public class StreamTest {

    public static void incrementPageVisit(Map<String, Integer> pageVisits, String page) {
        pageVisits.merge(page, 10, (oldValue, value) -> oldValue + value);
    }

    public static void print(int i) {
        System.out.println(i);
    }

    /**
     * 高阶函数
     */
    public static int totalSelectedValues(List<Integer> values, Predicate<Integer> selector) {
        return values.stream()
                     .filter(selector)
                     .reduce(0, Integer::sum);
    }

    /**
     * 创造重用lambda
     */
    public static Predicate<Integer> isGreateThan50() {
        return (number) -> number > 50;
    }

    public static Runnable create() {
        int value = 4;
        Runnable runnable = () -> System.out.println(value);

        System.out.println("exiting create");
        return runnable;
    }

    public static void main(String[] args) {
        Runnable runnable = create();

        System.out.println("In main");
        runnable.run();
    }

    @Test
    public void test1() {
        List<Integer> numbers = Arrays.asList(2, 5, 8, 15, 12, 19, 50, 23);
        System.out.println(
                numbers.stream()
                       .filter(e -> e > 10)
                       .filter(e -> e % 2 == 0)
                       .map(e -> e * 2)
                       .findFirst()
                       .map(e -> "The value is " + e)
                       .orElse("No value found"));

    }

    @Test
    public void test2() {
        List<Integer> numbers = Arrays.asList(2, 12, 5, 8, 15, 12, 19, 50, 23);
        System.out.println(
                numbers.stream()
                       .peek(e -> System.out.println("processing " + e))
                       .filter(e -> e > 10)
                       .filter(e -> e % 2 == 0)
                       .map(e -> e * 2)
                       .findFirst()
                       .map(e -> "The value is " + e)
                       .orElse("No value found"));
    }

    @Test
    public void test3() {
        Map<String, Integer> map = Maps.newHashMap();
        incrementPageVisit(map, "baidu");
        incrementPageVisit(map, "baidu");
        incrementPageVisit(map, "baidu");
        incrementPageVisit(map, "baidu2");
        System.out.println(map);

    }

    @Test
    public void test4() {
        List<Integer> numbers = Arrays.asList(2, 12, 5, 8, 15, 12, 19, 50, 23);
        IntStream.range(0, numbers.size()).forEach(i -> System.out.println(i + " " + numbers.get(i)));
    }

    @Test
    public void test5() {
        int total = 0;
        for (int i = 1; i <= 100; i++) {
            total += i;
        }
        System.out.println(total);
    }

    @Test
    public void test6() {
        IntStream.range(0, 4)
                 .forEach(StreamTest::print);
    }

    @Test
    public void testTotalSelectedValues() {
        List<Integer> numbers = Arrays.asList(2, 12, 5, 8, 15, 12, 19, 50, 23);
        System.out.println(totalSelectedValues(numbers, createIsOdd()));
    }

    public Predicate<Integer> createIsOdd() {
        return e -> e < 10;
    }

    @Test
    public void test() {
        List<Integer> numbers = Arrays.asList(2, 12, 5, 8, 15, 12, 19, 50, 23);
        List<Integer> result1 = numbers.stream()
                                       .filter(e -> e > 50)
                                       .collect(toList());

        List<Integer> result2 = numbers.stream()
                                       .filter(e -> e > 50)
                                       .map(e -> e * 2)
                                       .collect(toList());

        // 优化后
        List<Integer> result1_ = numbers.stream()
                                        .filter(isGreateThan50())
                                        .collect(toList());

        List<Integer> result2_ = numbers.stream()
                                        .filter(isGreateThan50())
                                        .map(e -> e * 2)
                                        .collect(toList());
    }

    @Test
    public void reduceSecondSign() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Integer count = list.stream().reduce(2, (a, b) -> (a * b));
        System.out.println(count);
    }

    @Test
    public void testMore() {
        List<Integer> numbers1 = Arrays.asList(2, 12, 5, 8, 15, 12, 19, 50, 23);
        Function<Integer, Predicate<Integer>> isGreaterThan = (pivot) -> {
            Predicate<Integer> isGreaterThanPivot = candidate -> {
                return candidate > pivot;
            };
            return isGreaterThanPivot;
        };
        List<Integer> valuesOver25 = numbers1.stream()
                                             .filter(e -> e > 25)
                                             .collect(toList());

        List<Integer> valuesOver50 = numbers1.stream()
                                             .filter(e -> e > 50)
                                             .collect(toList());

        List<Integer> valuesOver75 = numbers1.stream()
                                             .filter(isGreaterThan.apply(50))
                                             .collect(toList());


    }

    /**
     * reduce三种用法
     * 1.BinaryOperator<T> accumulator
     */
    @Test
    public void testReduce1() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = numbers.stream().reduce((a, b) -> a + b).get();
        System.out.println(sum);
    }

    /**
     * 提供一个初始值
     * T identity, BinaryOperator<T> accumulator
     */
    @Test
    public void testReduce2() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = numbers.stream().reduce(5, (a, b) -> a + b);
        System.out.println(sum);
    }

    /**
     * 提供一个初始值, 3个数据得可以改变结果类型 combiner为并发时调用得方法
     * T identity, BinaryOperator<T> accumulator combiner
     */
    @Test
    public void testReduce3() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream()
                                  .collect(toList()));

    }


}
