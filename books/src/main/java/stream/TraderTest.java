package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.joining;

/**
 * @author hgh 2019-09-10 16:35
 */
public class TraderTest {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");
    List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));


    @Test
    public void test() {
        //1
        transactions.stream()
                    .filter(e -> e.getYear() == 2011)
                    //                    .sorted((a1, a2) -> Integer.compare(a1.getValue(), a2.getValue()))
                    .sorted(comparingInt(Transaction::getValue))
                    .forEach(System.out::println);
        //2
        transactions.stream()
                    .map(Transaction::getTrader)
                    .map(Trader::getCity)
                    .distinct()
                    .forEach(System.out::println);
        //3
        transactions.stream()
                    .map(Transaction::getTrader)
                    .filter(trader -> trader.getCity().equals("Cambridge"))
                    .sorted(comparing(Trader::getName))
                    .forEach(System.out::println);
        //4
        transactions.stream()
                    .map(Transaction::getTrader)
                    .map(Trader::getName)
                    .distinct()
                    .sorted()
                    .collect(joining());

        transactions.stream()
                    .map(Transaction::getTrader)
                    .anyMatch(e -> "Milan".equals(e.getCity()));

        transactions.stream()
                    .filter(e -> "Cambridge".equals(e.getTrader().getCity()))
                    .mapToInt(Transaction::getValue)
                    .max();

        transactions.stream()
                    .max(comparing(Transaction::getValue));

        transactions.stream()
                    .min(comparing(Transaction::getValue));

    }

    @Test
    public void testRange() {
        IntStream.iterate(1, (a) -> a + 1).limit(300).forEach(System.out::println);

        IntStream.range(1, 100)
                 .filter(n -> n % 2 == 0)
                 .forEach(System.out::println);
    }

    @Test
    public void testRange12() {
        Stream.iterate(new int[]{0, 1}, (t) -> new int[]{t[1], t[0] + t[1]})
              .limit(20).forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
    }

    @Test
    public void testGenerator() {
        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);
    }


}
