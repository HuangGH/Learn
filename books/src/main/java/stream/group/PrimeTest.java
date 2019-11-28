package stream.group;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * @author hgh 2019-09-12 11:20
 */
public class PrimeTest {

    public boolean isPrime(int candidate) {
        return IntStream.range(2, candidate).noneMatch(i -> candidate % i == 0);
    }

    public boolean isPrime2(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate % i == 0);
    }

    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n)
                        .boxed()
                        .collect(
                                partitioningBy((candidate) -> isPrime(candidate)));
    }

    @Test
    public void test119() {
        System.out.println(partitionPrimes(100));
    }
}
