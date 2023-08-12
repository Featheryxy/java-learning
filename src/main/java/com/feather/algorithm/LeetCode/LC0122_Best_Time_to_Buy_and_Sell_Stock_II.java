package com.feather.algorithm.LeetCode;

import org.junit.Test;

/**
 * 122. 买卖股票的最佳时机 II
 * 中等
 * 2.2K
 * 相关企业
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 *      总利润为 4 + 3 = 7 。
 * 示例 2：
 *
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      总利润为 4 。
 * 示例 3：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
 *
 *
 * 提示：
 *
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 104
 *
 * @author Milo
 * @date 2023/8/12 9:54
 */
public class LC0122_Best_Time_to_Buy_and_Sell_Stock_II {
    @Test
    public void test(){
//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }

    // 如果后面有股价>当天股价，买入，并且记录利润
    public int maxProfit(int[] prices) {
        int res = 0; // 求最大值，初始值设为最小值，
//        if (prices.length <= 1) {
//            return res;
//        }

        int last = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int currPrice = prices[i];
            if (currPrice <= last) {
                last = currPrice;
                continue;
            }
            res = res + currPrice-last;
//            last = Integer.MAX_VALUE; // 当天不能买入
            last = currPrice; // 当天可以买入
        }
        return res;
    }

    // 找到所有的涨幅
    // 每一天都买入，下一天卖出，收集所有的正利润
    // 股价：7,1,5,3,6,4
    // 利润   -6，4，-2，3，-2
    // 利润最多   4+3 = 7
    public int maxProfitOffice(int[] prices) {
        int profit = 0;
        for (int i=1; i<prices.length; i++){
            if (prices[i]-prices[i-1]>0){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}
