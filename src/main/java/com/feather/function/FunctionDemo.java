package com.feather.function;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Milo
 * @date 2023/10/29 5:00
 */
public class FunctionDemo {
    @Test
    public void test(){
        Function<Integer, Integer> function1 = arg -> arg + 1;
        Function<Integer, Integer> function2 = arg -> arg *arg;
        Function<Integer, Integer> integerIntegerFunction = function1.andThen(function2);

        System.out.println(integerIntegerFunction.apply(3)); // (3+1)*(3+1)=16
    }

    @Test
    public void test1(){
        Predicate<String> predicate1 = s -> StringUtils.equals(s,"HELLO");
        Predicate<String> predicate2 = s -> StringUtils.equals(s,"WORLD");
        System.out.println(predicate1.or(predicate2).test("HELLO")); // false
    }
}
