package com.feather.gof.Visitor.A3;

import com.feather.gof.Visitor.Sample.File;

public abstract class Visitor {
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
}
