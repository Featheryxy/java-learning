package com.feather.gof.builder;



/**
 * @author Milo
 * @date 2024/10/7 14:05
 */
public class Main {
    public static void main(String[] args) {
        TextBuilder textBuilder = new TextBuilder();
        Director director = new Director(textBuilder);
        director.construct();
        String result = textBuilder.getResult();
        System.out.println(result);
    }
}
