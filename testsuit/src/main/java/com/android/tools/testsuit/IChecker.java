package com.android.tools.testsuit;

/**
 * @author qinchao
 * @since 2019/4/15
 */
public interface IChecker {
    void checkCondition(ConditionImpl condition);

    void checkResult(int count);
}
