package com.android.tools.testsuit;

/**
 * @author qinchao
 * @since 2019/4/15
 */
public interface ICondition {
    void shouldNotCall();

    void shouldCall(int serialNo);
}
