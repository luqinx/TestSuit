package com.android.tools.testsuit.internal;

/**
 * @author qinchao
 * @since 2019/5/6
 */
public interface IAsserts<T> {

    SampleRst<T> equalsWith(Object expect);

    SampleRst<T> equalsWith(int expect);

    SampleRst<T> equalsWith(long expect);

    SampleRst<T> equalsWith(float expect);

    SampleRst<T> equalsWith(double expect);

    SampleRst<T> notEqualsWith(Object object);

    SampleRst<T> notEqualsWith(int expect);

    SampleRst<T> notEqualsWith(long expect);

    SampleRst<T> notEqualsWith(float expect);

    SampleRst<T> notEqualsWith(double expect);

    SampleRst<T> isNull();

    SampleRst<T> notNull();

    SampleRst<T> instanceOf(Class<?> t);

    SampleRst<T> notInstanceOf(Class<?> t);

    SampleRst<T> sameWith(Object object);

    SampleRst<T> notSame(Object object);

    SampleRst<T> assertTrue();

    SampleRst<T> assertFalse();
}
