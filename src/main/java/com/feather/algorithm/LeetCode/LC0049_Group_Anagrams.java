package com.feather.algorithm.LeetCode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Milo
 * @date 2025/1/12 14:42
 */
public class LC0049_Group_Anagrams {
    @Test
    public void test(){
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<len; i++){
            String currStr = strs[i];
            char[] chars = currStr.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            // chars 继承的是Object的toString 方法
//            String sortStr = chars.toString();
            if (map.containsKey(sortStr)) {
                map.get(sortStr).add(currStr);
            } else {
                List<String> stringList = stringList = new ArrayList<>();
                stringList.add(currStr);
                map.put(sortStr, stringList);

            }
        }

        return new ArrayList<>(map.values());

    }

}
