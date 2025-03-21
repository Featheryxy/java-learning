package com.feather.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ALC0015_3Sum {


    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0, 0, 0};
//        int[] nums = {-2, 0, 0, 2, 2};
        System.out.println(threeSum(nums));

    }

    // 1. 排序
    // 2. 固定一个数，二分查找
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            int fixedNum = nums[i];
            // 数组单调递增，如果第一个数大于0，则nums[i] + nums[l] + nums[r] 必定大于0；
            if (fixedNum > 0) {
                return ans; // 提早返回
                //break;
            }
            // 答案中不可以包含重复的三元组。
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            // l不能等于r，因为不能有相同的数
            while (l < r) {
                int tmpSum = nums[l] + fixedNum + nums[r];
                if (tmpSum == 0) {
//                    List<Integer> tmpAns = new ArrayList<>();
//                    tmpAns.add(fixedNum);
//                    tmpAns.add(nums[l]);
//                    tmpAns.add(nums[r]);
//                    ans.add(tmpAns);
                    ans.add(Arrays.asList(fixedNum, nums[l], nums[r]));
                    // *** 指向最后一个相同的值 ,这里一定要有，否则会有重复答案，
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                    continue;
                }

                if (tmpSum > 0) {
                    r--;
                    continue;
                }

                if (tmpSum < 0) {
                    l++;
                    continue;
                }
            }

        }

        return ans;
    }


    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        int pre = nums[0];
        for(int i=0; i<len; i++) {
            if(i != 0)    {
                if(nums[i] == pre){
                    continue;
                } else {
                    pre = nums[i];
                }
            }

            for(int j=i+1; j<len;j++){
                if(j+1<len && nums[j+1]==nums[j]){
                    continue;
                }

                for(int k=j+1; k<len; k++) {
                    if(k+1<len && nums[k+1]==nums[k]){
                        continue;
                    }
                    if(nums[i]+nums[j]+nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        res.add(temp);
                    }
                }
            }
        }
        return res;
    }
}
