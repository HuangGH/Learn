package com.jdk8.stream;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hgh
 * @description Stream learn
 * @date 2019-06-03 17:35
 */
public class StreamTest {

    @Test
    public void testParrlelStream() {
        List<String> strings = Lists.newArrayList("ca", "12dsdsfaa", "dcasaa", "sdf");
        List<String> result = strings.stream().filter(e -> e.endsWith("a")).sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(result);
    }


}
