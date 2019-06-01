package com.android.tools.testsuit.internal;

/**
 * @author qinchao
 * @since 2019/5/6
 */
public interface Opt<T> extends IAsserts<T> {
    boolean exec(boolean rst);
}
