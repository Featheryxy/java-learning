package com.feather.gof.Visitor.A2;

import com.feather.gof.Visitor.A3.Directory;
import com.feather.gof.Visitor.A3.Entry;
import com.feather.gof.Visitor.A3.File;
import com.feather.gof.Visitor.A3.Visitor;

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
            com.feather.gof.Visitor.A3.Entry entry = (Entry)it.next();
            entry.accept(this);
        }
        currentdir = savedir;
    }
}
