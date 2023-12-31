package com.feather.gof.abstract_factory.listfactory;

import com.feather.gof.abstract_factory.factory.Factory;
import com.feather.gof.abstract_factory.factory.Link;
import com.feather.gof.abstract_factory.factory.Page;
import com.feather.gof.abstract_factory.factory.Tray;

public class ListFactory extends Factory {
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
