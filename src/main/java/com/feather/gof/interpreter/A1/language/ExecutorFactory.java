package com.feather.gof.interpreter.A1.language;

public interface ExecutorFactory {
    public abstract Executor createExecutor(String name);
}
