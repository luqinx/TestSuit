package com.android.tools.testsuit.internal;

/**
 * @author qinchao
 * @since 2019/5/6
 */
public abstract class SampleNode<T> {

    private SampleNode<T> parentNode;

    private SampleNode<T> childNode;

    private T target;

    public SampleNode(SampleNode<T> parent, T target) {
        parentNode = parent;
        this.target = target;
    }

    public SampleNode<T> parent() {
        return parentNode;
    }

    void setChild(SampleNode<T> child) {
        this.childNode = child;
    }

    public SampleNode<T> child() {
        return childNode;
    }

    public T target() {
        return target;
    }

    abstract String optMessage();

    abstract String message();

    abstract void asserts(boolean failed);
}
