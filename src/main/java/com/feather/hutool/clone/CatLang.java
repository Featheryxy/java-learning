package com.feather.hutool.clone;

/**
 * @author Milo
 * @date 7/31/2024 10:11 PM
 */
public class CatLang implements Cloneable{
    private String name = "miaomiao";


    @Override
    protected CatLang clone()  {
        try {
            return (CatLang)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        CatLang catLang = new CatLang();
        CatLang clone = catLang.clone();
        System.out.println(clone.name);


    }
}
