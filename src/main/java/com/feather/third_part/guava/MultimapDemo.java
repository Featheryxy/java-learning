package com.feather.third_part.guava;

import com.google.common.collect.HashMultimap;
import org.junit.Test;

import java.util.*;

/**
 * @author Milo
 * @date 2023/7/29 19:23
 * Map<K, Collection<V>>
 */
public class MultimapDemo {
    @Test
    public void test(){
        HashMultimap<String, String> hashMultimap = HashMultimap.create();
        hashMultimap.put("GroupA", "小明");
        hashMultimap.put("GroupA", "小明");
        hashMultimap.put("GroupA", "小红");
        hashMultimap.put("GroupB", "小叶");
        hashMultimap.put("GroupB", "小丽");
        System.out.println(hashMultimap);

        boolean hasGroupA = hashMultimap.containsKey("GroupA");
        boolean hasMrYe = hashMultimap.containsValue("小叶");
        boolean hasEntry = hashMultimap.containsEntry("GroupB", "小叶");
        Set<String> groupA = hashMultimap.get("GroupA");


        Map<String, Collection<String>> map = hashMultimap.asMap();
        System.out.println(map);

        // {GroupA=[小明, 小红], GroupB=[小叶, 小丽]}
        // {GroupA=[小明, 小红], GroupB=[小叶, 小丽]}
    }

    @Test
    public void test2(){
        HashMultimap<String, List<Integer>> hashMultimap = HashMultimap.create();
        Integer [] intArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> digitList = Arrays.asList(intArr); // 该方法返回的是Arrays的内部类ArrayList
        digitList = new ArrayList<>(digitList);

        List<Integer> digitList1 = digitList.subList(0, 4);
        List<Integer> digitList2 = digitList.subList(4, 8);
        List<Integer> digitList3 = digitList.subList(8, digitList.size());
        hashMultimap.put("digit", digitList1);
        hashMultimap.put("digit", digitList2);
        hashMultimap.put("digit", digitList3);

        System.out.println(hashMultimap);
        // {digit=[[4, 5, 6, 7], [0, 1, 2, 3], [8, 9]]}
    }
}
