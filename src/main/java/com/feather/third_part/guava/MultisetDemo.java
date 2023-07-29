package com.feather.third_part.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;

import java.util.Set;

/**
 * @author Milo
 * @date 2023/7/29 17:22
 */
public class MultisetDemo {
    /**
     *  Map<E, Count> backingMap
     */
    @Test
    public void test(){
        HashMultiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        System.out.println(multiset);
        // [a x 2, b, c]

        for (Multiset.Entry<String> set:multiset.entrySet()) {

            String format = String.format("key: %s, count: %s", set.getElement(), set.getCount());
            System.out.println(format);

        }

    }
}
