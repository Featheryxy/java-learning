package com.feather.algorithm.LeetCode;

import com.feather.algorithm.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Milo
 * @date 2025/3/10 17:10
 */
public class LC0697_Degree_of_an_Array {
    Tag[] tags = {Tag.ARRAY};

    /**
     * 1. 统计数组中每个元素的出现的频率
     * 2. firstIndexMap 记录 元素第一次出现的位置， lastIndexMap 记录 元素最后出现的位置
     * 3. 找到频率最大的那个数首尾指针
     *
     * 因为题目中要求是连续的
     * tips:
     *  map.putIfAbsent(num, i); // 记录第一次出现的地方
     *  map.put(num, i); // 记录最后一次出现的地方
     *  map.put(num, map.getOrDefault(num, 0) + 1); // 统计  num出现的频率
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        // 元素出现频率
        Map<Integer, Integer> countMap = new HashMap<>();
        // 元素第一次出现的位置
        Map<Integer, Integer> firstIndexMap = new HashMap<>();

        // 元素最后出现的位置
        Map<Integer, Integer> lastIndexMap = new HashMap<>();

        int maxDegree = 0, minLength = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            maxDegree = Math.max(maxDegree, countMap.get(num));
            firstIndexMap.putIfAbsent(num, i);
            lastIndexMap.put(num, i);
        }

        for (int num : nums) {
            if (countMap.get(num) == maxDegree) {
                int temLength = lastIndexMap.get(num) - firstIndexMap.get(num) + 1;
                minLength = Math.min(temLength, minLength);
            }
        }

        return minLength;

    }
}
