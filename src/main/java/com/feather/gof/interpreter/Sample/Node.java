package com.feather.gof.interpreter.Sample;

public abstract class Node {
    public abstract void parse(Context context) throws ParseException;
}
