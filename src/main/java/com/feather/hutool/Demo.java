package com.feather.hutool;

import cn.hutool.Hutool;
import org.junit.Test;

import java.util.Set;

/**
 * @author Milo
 * @date 7/31/2024 10:06 PM
 */
public class Demo {
    @Test
    public void test() {
        Set<Class<?>> allUtils = Hutool.getAllUtils();
        System.out.println(allUtils);

    }
}
