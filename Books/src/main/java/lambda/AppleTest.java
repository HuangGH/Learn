package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hgh 2019-09-05 17:52
 */
public class AppleTest {
    Apple apple1 = new Apple("red", 20);
    Apple apple2 = new Apple("black", 30);

    public static List<Apple> filter(List<Apple> list, ApplePredicate applePredicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (applePredicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    @Test
    public void test() {
        List<Apple> apples = Arrays.asList(apple1, apple2);
        ApplePredicate aplePredicatea = (Apple a) -> "red".equals(a.getColor());

        List result = filter(apples, aplePredicatea.negate());

        List result2 = filter(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }

            @Override
            public ApplePredicate negate() {
                return (Apple apple) -> !test(apple);
            }
        });

        System.out.println(result);

    }

}
