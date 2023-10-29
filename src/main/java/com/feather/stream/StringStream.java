package com.feather.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Date 2023/3/3 17:44
 * @Created by Milo
 */
public class StringStream {
    @Test
    public void test(){
        String str = "0,1,2,3,4,5,6,7,8,9";
        String[] split = str.split(",");
        String beg = "(";
        StringBuilder stringBuilder = new StringBuilder(beg);
        for (int i = 0; i < split.length; i++) {
            stringBuilder.append("'")
                    .append(split[i])
                    .append("'");
            if (i != split.length-1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        System.out.println(stringBuilder.toString());
    }

    @Test
    public void testReduce(){
        String str = "0,1,2,3,4,5,6,7,8,9";
        String[] split = str.split(",");
        String reduce = Arrays.stream(split).reduce("(", (x, y) -> x = x + "','" + y);
        System.out.println(reduce);
    }

    @Test
    public void test1() {
        String str = "0,1,2,3,4,5,6,7,8,9";
        String[] split = str.split(",");
        String collect = Arrays.stream(split)
                .map(s -> "'" + s + "'")
                .collect(Collectors.joining(",", "(", ")"));
        System.out.println(collect);
    }

    @Test
    public void test2() {
        String str = "0,1,2,3,4,9,5,6,7,8";
        String[] split = str.split(",");
        Stream<String> split1 = Stream.of(split);
//        split1.sorted(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                Character
//            }
//        })
    }
}

