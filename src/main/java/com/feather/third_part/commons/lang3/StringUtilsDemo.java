package com.feather.third_part.commons.lang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author Milo
 * @date 2023/7/29 16:00
 *
 * isEmpty(final CharSequence cs)
 * isBlank(final CharSequence cs)
 * String left(final String str, final int len)
 * String leftPad(final String str, final int size, final char padChar)
 */
public class StringUtilsDemo {


    /**
     *  isEmpty(final CharSequence cs)
     *  isBlank(final CharSequence cs)
     *  isAllBlank(final CharSequence... css)
     *  isAnyBlank(final CharSequence... css)
     *
     *     blank: null, "", "  "
     *     empty: null, ""
     *     blank = empty + "  "
     */
    @Test
    public void test1(){
        boolean empty = StringUtils.isEmpty(" ");
        System.out.println(empty);

        boolean blank = StringUtils.isBlank("  ");
        System.out.println(blank);


        boolean allBlank = StringUtils.isAllBlank(" ", "", null);
        System.out.println(allBlank);

        boolean anyBlank = StringUtils.isAnyBlank(" ", "", null, "123");
        System.out.println(anyBlank);
    }


    /**
     *  String left(final String str, final int len)
     *  String leftPad(final String str, final int size, final char padChar)
     */
    @Test
    public void test(){
        String str = "123456789";
        String left = StringUtils.left(str, 3);
        System.out.println("left: " + left);

        String right = StringUtils.right(str, 3);
        System.out.println("right: " + right);

        String rightPad = StringUtils.rightPad("123", 5, "*");
        System.out.println("rightPad: "+rightPad);
    }
}
