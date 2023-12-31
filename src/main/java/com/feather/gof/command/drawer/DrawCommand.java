package com.feather.gof.command.drawer;

import com.feather.gof.command.command.Command;

import java.awt.*;

public class DrawCommand implements Command {
    // 绘制对象
    protected Drawable drawable;

    private Point position;

    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}
