package com.feather.gof.facade.Sample;


import com.feather.gof.facade.Sample.pagemaker.PageMaker;

public class Main {
    public static void main(String[] args) {
        PageMaker.makeWelcomePage("hyuki@hyuki.com", "welcome.html");
    }
}
