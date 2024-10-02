package com.feather.hutool;

import cn.hutool.core.convert.Convert;
import org.junit.Test;

/**
 * @author Milo
 * @date 7/31/2024 10:23 PM
 */
public class ConvertDemo {
    @Test
    public void test(){
        int a = 1;
        //aStr为"1"
        String aStr = Convert.toStr(a);

        long[] b = {1,2,3,4,5};
        //bStr为："[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(b);
    }
}
