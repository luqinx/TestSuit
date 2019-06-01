package com.android.tools.testsuit.internal;

/**
 * @author qinchao
 * @since 2019/5/6
 */
abstract class AbsOpt<T> extends AssertsImpl<T> implements Opt<T> {


    private boolean lastRst;

    public AbsOpt(SampleNode<T> parent, boolean lastRst) {
        super(parent, parent.target());
        this.lastRst = lastRst;

    }

    boolean lastRst() {
        return lastRst;
    }

}
