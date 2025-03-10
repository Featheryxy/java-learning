package com.feather.algorithm.LeetCode;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC1348 推文计数
 *
 * @author Milo
 * @date 2025/3/10 16:52
 */
public class TweetCounts {
    // 存储推文时间数据，tweetName -> 时间点列表
    private final Map<String, List<Integer>> tweetMap;

    public TweetCounts() {
        tweetMap = new HashMap<>();
    }

    public static void main(String[] args) {
        TweetCounts tweetCounts = new TweetCounts();
        tweetCounts.recordTweet("tweet1", 60);
        tweetCounts.recordTweet("tweet1", 60);
        tweetCounts.recordTweet("tweet1", 70);

        System.out.println(tweetCounts.getTweetCountsPerFrequency("minute", "tweet1", 0, 80)); // [2]
//        System.out.println(tweetCounts.getTweetCountsPerFrequency("minute", "tweet1", 0, 2)); // [3]
//        System.out.println(tweetCounts.getTweetCountsPerFrequency("hour", "tweet1", 0, 3600)); // [3]
    }

    // 记录推文
    public void recordTweet(String tweetName, int time) {
        tweetMap.putIfAbsent(tweetName, new ArrayList<>());
        tweetMap.get(tweetName).add(time);
    }

    // 获取指定推文在指定时间范围内的推文数目，按频率分组
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> result = new ArrayList<>();

        // 获取推文的时间列表
        List<Integer> tweetTimes = tweetMap.getOrDefault(tweetName, new ArrayList<>());

        // 确定每个频率的时间跨度（例如：一分钟 = 60秒，小时 = 3600秒，天 = 86400秒）
        int interval = 0;
        switch (freq) {
            case "minute":
                interval = 60;
                break;
            case "hour":
                interval = 3600;
                break;
            case "day":
                interval = 86400;
                break;
        }

        // 将推文按时间分组, 索引 = 组间+1
        int n = (endTime - startTime) / interval + 1;
        int[] count = new int[n];

        for (int time : tweetTimes) {
            if (time >= startTime && time <= endTime) {
                int index = (time - startTime) / interval;
                count[index]++;
            }
        }

        // 转换为结果列表
        for (int c : count) {
            result.add(c);
        }

        return result;
    }

    @Test
    public void test(){

    }

}
