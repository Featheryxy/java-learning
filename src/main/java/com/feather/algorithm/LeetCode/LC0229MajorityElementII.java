package com.feather.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：[3]
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,2]
 * 输出：[1,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/majority-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0229MajorityElementII {
    public static void main(String[] args) {

    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Integer appereadNums = nums.length / 3;


        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

//        for (Integer key : map.keySet()) {
//            if (map.get(key) > appereadNums) {
//                ret.add(key);
//            }
//        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > appereadNums) {
                ret.add(entry.getKey());
            }
        }

        return ret;

    }
}
