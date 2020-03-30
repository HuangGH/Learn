package com.math;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * @author hgh
 * @since 2020-03-09 14:42
 */
@Slf4j
public class BigDecimlTest {
    public static void main(String[] args) {
        BigDecimal decimal = new BigDecimal(0).setScale(8);

        List<BigDecimal> list = Lists.newArrayList(decimal);
        BigDecimal bigDecimal = list.stream()
                                    .filter(Objects::nonNull)
                                    .reduce(BigDecimal::add)
                                    .orElse(BigDecimal.ZERO);
        log.info("" + bigDecimal);
        log.info("" + new BigDecimal(0));
    }
}
