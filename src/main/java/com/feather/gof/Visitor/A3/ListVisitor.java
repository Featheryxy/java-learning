package com.feather.gof.Visitor.A3;

import com.feather.gof.Visitor.Sample.Directory;
import com.feather.gof.Visitor.Sample.Entry;
import com.feather.gof.Visitor.Sample.File;
import com.feather.gof.Visitor.Sample.Visitor;

import java.util.Iterator;

public class ListVisitor extends Visitor {
    private String currentdir = "";                         // 当前访问的文件夹的名字
    public void visit(File file) {                  // 在访问文件时被调用
        System.out.println(currentdir + "/" + file);
    }
    public void visit(Directory directory) {   // 在访问文件夹时被调用
        System.out.println(currentdir + "/" + directory);
        String savedir = currentdir;
        currentdir = currentdir + "/" + directory.getName();
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            com.feather.gof.Visitor.Sample.Entry entry = (Entry)it.next();
            entry.accept(this);
        }
        currentdir = savedir;
    }
}
