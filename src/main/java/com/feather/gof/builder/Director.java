package com.feather.gof.builder;

/**
 * @author Milo
 * @date 2024/10/7 13:51
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(){
        builder.makeTitle("Greeting");
        builder.makeString("从早上至下午");
        builder.makeItems(new String[]{
                "早上好。",
                "x下午好。"
        });
        builder.close();
    }
}
