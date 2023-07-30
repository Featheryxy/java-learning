package com.feather.basic;

import org.junit.Test;

/**
 * @Date 2023/4/12 14:46
 * @Created by Milo
 */

//  enum ind/milo/demo/basic/ColorEnum extends java/lang/Enum
//   Enum 定义的枚举类默认继承了 java.lang.Enum 类。
//  每个枚举值都是一个枚举对象，每个对象都有name和ordinal属性
//  name为枚举变量的名称
//  ordinal为枚举变量在枚举类中声明的顺序，下标从0开始
public enum ColorEnum {
    red("红色"),
    yellow("黄色"),
    blue("蓝色");


    private String comment;
    ColorEnum(String comment){
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ColorEnum{" +
                "comment='" + comment + '\'' +
                '}';
    }

    @Test
    public void test(){
        for (ColorEnum tmp : ColorEnum.values()) {
            System.out.println(tmp.name()+" "+tmp.ordinal()+" "+ tmp.comment);
        }
    }

    public static void main(String[] args) throws Exception {
        ColorEnum colorEnum = ColorEnum.red;
        switch (colorEnum) {
            case red:
                System.out.println(red.name());
                break;
            case blue:
                break;
            default:
                throw new Exception("未定义该枚举值");
        }
    }
}
