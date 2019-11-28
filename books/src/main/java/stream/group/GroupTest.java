package stream.group;

import org.junit.Test;
import stream.Dish;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static stream.Dish.menu;

/**
 * @author hgh 2019-09-11 15:50
 */
public class GroupTest {

    @Test
    public void test() {
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);
    }

    @Test
    public void test1() {
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
            else return CaloricLevel.FAT;
        }));

        System.out.println(dishesByCaloricLevel);
    }

    @Test
    public void testGroupByBy() {
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(groupingBy(Dish::getType, groupingBy(dish -> {
            if (dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        })));

        System.out.println(dishesByTypeCaloricLevel);
    }


    @Test
    public void testGroupByCount() {
        Map<Dish.Type, Long> dishesByTypeCaloricLevel = menu.stream().collect(groupingBy(Dish::getType, counting()));
        System.out.println(dishesByTypeCaloricLevel);
    }

    @Test
    public void testGroupByCount1() {
        Map<Dish.Type, Optional<Dish>> dishesByTypeCaloricLevel = menu.stream()
                                                                      .collect(groupingBy(Dish::getType,
                                                                              maxBy(comparingInt(Dish::getCalories))));
        System.out.println(dishesByTypeCaloricLevel);
    }

    @Test
    public void testCollectingAndThen() {
        Map<Dish.Type, Dish> dishesByTypeCaloricLevel = menu.stream()
                                                            .collect(groupingBy(Dish::getType,
                                                                    collectingAndThen(
                                                                            maxBy(comparingInt(Dish::getCalories)),
                                                                            Optional::get)));

        Collectors.collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get);
        System.out.println(dishesByTypeCaloricLevel);
    }

    @Test
    public void testMappring() {
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream().collect(groupingBy(Dish::getType, mapping(dish -> {
            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
            else return CaloricLevel.FAT;
        }, toSet())));
        System.out.println(caloricLevelsByType);
    }

    // 分区
    @Test
    public void testPartitiongby() {

        Map<Boolean, List<Dish>> partitionedMenu = menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);
    }

    // 分区
    @Test
    public void testPartitiongby2() {
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
        System.out.println(vegetarianDishesByType);
    }

}
