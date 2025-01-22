package com.feather.gof.builder;

/**
 * @author Milo
 * @date 2024/10/7 13:49
 */
public abstract class Builder {
    public abstract void makeTitle(String title);
    public abstract void makeString(String str);
    public abstract void makeItems(String[] items);
    public abstract void close();

}
