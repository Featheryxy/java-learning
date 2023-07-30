package com.feather.algorithm;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author Milo
 * @date 2023/7/30 22:49
 */
public class TagTest extends TestCase {
    @Test
    public void test(){
        Tag[] values = Tag.values();
        for (Tag tag : values) {
            System.out.println(tag.name()+" "+tag.ordinal());
        }
    }
}