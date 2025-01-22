package com.feather.gof.Visitor.A3;

import com.feather.gof.Visitor.Sample.Element;
import com.feather.gof.Visitor.Sample.Visitor;

import java.util.ArrayList;
import java.util.Iterator;

class ElementArrayList extends ArrayList implements com.feather.gof.Visitor.Sample.Element {
    public void accept(Visitor v) {
        Iterator it = iterator();
        while (it.hasNext()) {
            com.feather.gof.Visitor.Sample.Element e = (Element)it.next();
            e.accept(v);
        }
    }
}
