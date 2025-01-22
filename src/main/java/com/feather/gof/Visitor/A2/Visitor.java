package com.feather.gof.Visitor.A2;

import com.feather.gof.Visitor.A3.File;

public abstract class Visitor {
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
}
