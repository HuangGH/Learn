import org.junit.Test;

import java.util.stream.LongStream;

/**
 * @author hgh 2019-09-19 23:35
 */
public class Parallel {

    public static long iterativeSum1(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }


    public static long iterativeSum2(long n) {
        return LongStream.iterate(1L, i -> i + 1)
                         .limit(n)
                         .filter(index -> index > 5)
                         .sequential()
                         .reduce(Long::sum).getAsLong();

    }

    @Test
    public void test() {
        System.out.println(iterativeSum1(10000));
        System.out.println(iterativeSum2(10000));
    }
}
