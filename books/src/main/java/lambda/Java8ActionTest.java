package lambda;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author hgh 2019-09-03 19:35
 */

public class Java8ActionTest {


    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

    public static String processFile(Bufferedreaderprocessor bufferedreaderprocessor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return bufferedreaderprocessor.process(br);
        }
    }

    public static String filter(String orgian, Predicate<String> predicate) {
        if (predicate.test(orgian)) {
            return "true";
        } else {
            return "false";
        }
    }

    public void test() {
        Runnable runnable = () -> {
        };
    }

    @Test
    public void testLambda() throws IOException {
        processFile((BufferedReader bf) -> bf.readLine());

        new Bufferedreaderprocessor() {
            @Override
            public String process(BufferedReader br) throws IOException {
                return br.readLine();
            }
        };
    }

    @Test
    public void testReturnVoid() {
        String result = filter("haha1", (String chars) -> chars.length() > 5);
        System.out.println(result);
        List<String> list = new ArrayList<>();
        Predicate<String> p = s -> list.add(s); // lambda void特殊兼容
        Consumer<String> p2 = s -> list.add(s);
    }

    @Test
    public void testOut() {
        //		Object o = () -> System.out.println("Tricky example"); };

        int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);
        int a = 123;
        int b = 12333;

        Comparator<Integer> c1 = (Integer a1, Integer b1) -> a1.compareTo(b1);
        Comparator<Integer> c2 = Integer::compare;

        List<Integer> a1 = Arrays.asList(1, 2, 5, 6, 3);

        a1.sort((number1, number2) -> number1.compareTo(number2));
        //		a1.sort(Integer::compareTo);


        //		a1.sort(Comparator.comparing((Integer i) -> i));


        //		a1.sort(Integer::compareTo);


        System.out.println(a1);
    }

    public void testOhtier() {
        List<String> str = Arrays.asList("a", "b", "A", "B");
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
    }
}
