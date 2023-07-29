package com.feather.third_part.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multiset;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Milo
 * @date 2023/7/29 16:48
 *
 * Joiner/Splitter
 */
public class JoinerDemo {
    @Test
    public void test(){
        ImmutableList<String> list = ImmutableList.of("a", "b", "c");
        List<String> hasNullList = new ArrayList<>(list);
        hasNullList.add(null);
        System.out.println(hasNullList);
        // [a, b, c, null]

        Joiner joiner = Joiner.on(",").skipNulls();
        String listStr = joiner.join(hasNullList);
        System.out.println(listStr);
        // a,b,c

        String collect = hasNullList.stream()
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.joining(",", "{", "}"));
        System.out.println(collect);
        // {a,b,c}
    }

    @Test
    public void test1(){
        Splitter splitter = Splitter.on(",");
        List<String> strings = splitter.splitToList("a,b,c");
        System.out.println(strings);
    }
}
