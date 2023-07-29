package com.feather.third_part.commons.collections;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Milo
 * @date 2023/7/29 16:39
 *
 *  isEmpty(Collection<?> coll)
 *
 */
public class CollectionUtilsDemo {

    /**
     * isEmpty(Collection<?> coll)
     */
    @Test
    public void test1(){
        CollectionUtils.isEmpty(new ArrayList<>());
    }

    @Test
    public void test(){
//        CollectionUtils.intersection()
    }
}
