package com.android.tools.testsuit.internal;

import chao.app.interceptor.Interceptor;
import chao.app.interceptor.OnAfterListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SampleRst<T> {

    public IAsserts and;

    public IAsserts or;

    public IAsserts not;

    private SampleNode parentNode;

    private boolean notFailed;

    private boolean rstNotFailed;

    SampleRst(SampleNode<T> parent, boolean rstNotFailed) {
        this.parentNode = parent;
        this.rstNotFailed = rstNotFailed;
        this.notFailed = rstNotFailed;
        and = proxy(new OptAndImpl<>(parent, notFailed));
        or = proxy(new OptOrImpl<>(parent, notFailed));
        not = proxy(new OptNotImpl<>(parent, notFailed));
    }

    public void asserts() {
        parentNode.asserts(!notFailed);
    }


    private IAsserts proxy(final Opt<T> asserts) {
        return Interceptor.of(asserts, Opt.class).after(new OnAfterListener<Opt<T>>() {
            @Override
            public Object onAfterInterceptor(Opt<T> source, Method method, Object[] args, Object result) {

                if (result instanceof SampleRst) {
                    SampleRst rst = (SampleRst) result;
                    parentNode.setChild((SampleNode<T>) source);
                    notFailed = source.exec(rst.rstNotFailed);
                    if (!notFailed) {
                        asserts();
                    }
                    return rst;
                } else {
                    try {
                        return method.invoke(source, args);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        }).newInstance();
    }
}