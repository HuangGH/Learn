package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static stream.Dish.menu;

/**
 * @author hgh 2019-09-08 16:48
 */
public class StreamDemoTest {

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    @Test
    public void streamDemo() {
        List<String> threeHighCaloricDishNames =
                Dish.menu.stream()
                         .filter(d -> d.getCalories() > 300)
                         .map(Dish::getName)
                         // .limit(3)
                         .collect(toList());
        System.out.println(threeHighCaloricDishNames);
    }

    @Test
    public void test() {
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println);

        String[] arrayOfWords = {"Goodbye", "World"};
        Arrays.stream(arrayOfWords);
    }

    @Test
    public void testIntStream() {
        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100)
                         .boxed()
                         .flatMap(a -> IntStream.rangeClosed(a, 100)
                                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
    }

    public void testFlatMap() {
    }

    @Test
    public void testFlatMap1() {
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);

        System.out.println(words.stream()
                                .map(word -> word.split(""))
                                .map(Arrays::stream)
                                .distinct()
                                .collect(toList()));
        System.out.println(words.stream()
                                .map(word -> word.split(""))
                                .flatMap(e -> Arrays.stream(e))
                                .distinct()
                                .collect(toList()));


    }

    @Test
    public void testFindAny() {
        Optional<Dish> dish = menu.parallelStream()
                                  .filter(Dish::isVegetarian)
                                  .findAny();
        dish.ifPresent(System.out::println);
    }

    @Test
    public void testReduce() {
        int product = numbers.stream()
                             .reduce(1, (a, b) -> a * b);
        System.out.println(product);
    }

    @Test
    public void testReduce2() {
        Optional<Integer> product = numbers.stream()
                                           .reduce((a, b) -> a * b);
        System.out.println(product.get());
    }

    @Test
    public void testGetMax() {
        numbers.stream()
               .reduce(Integer::max);
    }

}
