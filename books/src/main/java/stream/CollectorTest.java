package stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static stream.Dish.menu;

/**
 * @author hgh 2019-09-11 13:57
 */
public class CollectorTest {

    // 汇总
    @Test
    public void testCounting() {
        long howManyDishes = menu.stream()
                                 .collect(counting());
        System.out.println(howManyDishes);
    }

    //查找最大值、最小值
    @Test
    public void testMax() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream()
                                             .collect(maxBy(dishCaloriesComparator));
        mostCalorieDish.ifPresent(System.out::println);
    }

    // summingInt
    @Test
    public void testSumInt() {
        // 平均值
        int totalCalories = menu.stream()
                                .collect(summingInt(Dish::getCalories));
        double averageCalories = menu.stream()
                                     .collect(averagingInt(Dish::getCalories));
        IntSummaryStatistics menuStatistics = menu.stream()
                                                  .collect(summarizingInt(Dish::getCalories));
        System.out.println(totalCalories);
        System.out.println(averageCalories);
        System.out.println(menuStatistics);
    }

    @Test
    public void testJoining() {
        String shortMenu = menu.stream()
                               .map(Dish::getName)
                               .collect(joining(", "));
        System.out.println(shortMenu);
    }

    @Test
    public void testCollect() {
        int totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));


        Optional<Dish> mostCalorieDish = menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
    }

    /**
     * 错误示例
     * 这个解决方案有两个问题:一个语义问题和一个实际问题。语义问题在于,reduce方法旨在把两个值结合起来生成一个新值,它是一个不可变的归约。
     * 与此相反, collect方法的设计就是要改变容器,从而累积要输出的结果。这意味着,上面的代码片段是在滥用reduce方法,因为它在原地改变了作为累加器的List。
     * 你在下一章中会更详细地看到,以错误的语义使用reduce方法还会造成一个实际问题:这个归约过程不能并行工作,
     * 因为由多个线程并发修改同一个数据结构可能会破坏List本身。在这种情况下,如果你想要线程安全,就需要每次分配一个新的List,而对象分配又会影响性能。
     * 这就是collect方法特别适合表达可变容器上的归约的原因,更关键的是它适合并行操作,本章后面会谈到这一点
     */
    public void testCollectDiffReduce() {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6)
                                       .stream();
        List<Integer> numbers = stream.reduce(new ArrayList<>(), (List<Integer> l, Integer e) -> {
            l.add(e);
            return l;
        }, (List<Integer> l1, List<Integer> l2) -> {
            l1.addAll(l2);
            int totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
            return l1;
        });
    }

    // 收集框架的灵活性:以不同的方法执行同样的操作
    @Test
    public void test() {
        int totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        int totalCalories2 = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        int totalCalories3 = menu.stream().mapToInt(Dish::getCalories).sum();
    }
}
