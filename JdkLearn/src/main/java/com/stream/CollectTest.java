package com.stream;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @author hgh 2019-08-26 12:31
 */
public class CollectTest {

    @Test
    public void test3() {
        final Integer[] integers = Lists.newArrayList(1, 2, 3, 4, 5)
                                        .stream()
                                        .collect(() -> new Integer[]{0}, (a, x) -> a[0] += x, (a1, a2) -> a1[0] += a2[0]);
        System.out.println(integers[0]);

    }

    @Test
    public void test1() {

        Lists.<Person>newArrayList().stream()
                                    .collect(() -> new HashMap<Integer, List<Person>>(),
                                            (h, x) -> {
                                                List<Person> value = h.getOrDefault(x.getType(), Lists.newArrayList());
                                                value.add(x);
                                                h.put(x.getType(), value);
                                            }, HashMap::putAll
                                            );
    }

}
