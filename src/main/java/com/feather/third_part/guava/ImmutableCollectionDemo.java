package com.feather.third_part.guava;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Milo
 * @date 2023/7/29 12:03
 */
public class ImmutableCollectionDemo {
    @Test
    public void test(){
        ImmutableList<String> immutableList = ImmutableList.of("a","b","c");
        System.out.println(immutableList);

        List<String> list  = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        ImmutableList<String> immutableList1 = ImmutableList.<String>builder().addAll(list).add("d").build();
        System.out.println(immutableList1);
    }
}
