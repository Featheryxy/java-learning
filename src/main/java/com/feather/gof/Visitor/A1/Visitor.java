package com.feather.gof.Visitor.A1;

import com.feather.gof.Visitor.A2.File;

public abstract class Visitor {
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
}
