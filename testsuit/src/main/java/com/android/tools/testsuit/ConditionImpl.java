package com.android.tools.testsuit;

/**
 * @author qinchao
 * @since 2019/4/15
 */
public class ConditionImpl implements ICondition {

    int serialNo;

    private IChecker checker;

    public ConditionImpl(IChecker checker) {
        this.checker = checker;
    }

    @Override
    public void shouldNotCall() {
        throw new TestException("method should not be but called");
    }

    @Override
    public void shouldCall(int serialNo) {
        this.serialNo = serialNo;
        checker.checkCondition(this);
    }
}
