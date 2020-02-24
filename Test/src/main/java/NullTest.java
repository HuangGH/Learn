import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @author hgh 2019-12-19 15:16
 */
public class NullTest {


    public static void main(String[] args) throws InterruptedException {
        LocalDateTime start = LocalDateTime.now();
        //        TimeUnit.SECONDS.sleep(63L);
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);

        String key = "idcash/job/testdf";
        String value = key.substring(key.lastIndexOf("/") + 1);
        System.out.println(value);


        long a = Instant.now().getEpochSecond();
        //        TimeUnit.SECONDS.sleep(5);
        long b = Instant.now().getEpochSecond();
        System.out.println(b - a);
    }
}
