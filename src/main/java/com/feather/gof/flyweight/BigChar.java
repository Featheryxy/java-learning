package com.feather.gof.flyweight;

import com.feather.util.NIOUtil;

public class BigChar {
    private char charname;
    private String fontdate;

    public BigChar(char charName) {
        String path = "F:\\GitHubNote\\java-learning\\src\\main\\java\\com\\feather\\gof\\flyweight\\bigchar\\";
        String file = path+"big" + charName + ".txt";
        fontdate = NIOUtil.read(file);
    }

    public void print() {
        System.out.print(fontdate);
    }

    public static void main(String[] args) {
        BigChar bigChar = new BigChar('0');
        bigChar.print();
    }
}
