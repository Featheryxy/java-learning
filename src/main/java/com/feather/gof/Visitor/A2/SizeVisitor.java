package com.feather.gof.Visitor.A2;

import com.feather.gof.Visitor.A3.Directory;
import com.feather.gof.Visitor.A3.Entry;
import com.feather.gof.Visitor.A3.File;
import com.feather.gof.Visitor.A3.Visitor;

import java.util.Iterator;

public class SizeVisitor extends Visitor {
    private int size = 0;
    public int getSize() {
        return size;
    }
    public void visit(File file) {
        size += file.getSize();
    }
    public void visit(Directory directory) {
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            com.feather.gof.Visitor.A3.Entry entry = (Entry)it.next();
            entry.accept(this);
        }
    }
}
