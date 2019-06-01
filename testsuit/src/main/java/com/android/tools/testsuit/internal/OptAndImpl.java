package com.android.tools.testsuit.internal;

/**
 * @author qinchao
 * @since 2019/5/6
 */
public class OptAndImpl<T> extends AbsOpt<T> implements OptAnd<T> {

    public OptAndImpl(SampleNode<T> parent, boolean lastRst) {
        super(parent, lastRst);
    }

    @Override
    public boolean exec(boolean rst) {
        return lastRst() && rst;
    }

    @Override
    public String preMessage() {
        return "\n    and";
    }
}
