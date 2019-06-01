package com.android.tools.testsuit;

/**
 * @author qinchao
 * @since 2019/4/15
 */
public class CallPriorityChecker extends CallCountChecker {

    @Override
    public void checkCondition(ConditionImpl condition) {
        int oldCallMask = callMask;
        super.checkCondition(condition);

        final int serialNo = condition.serialNo;

        int serialBit = 1 << (serialNo - 1);
        int highestOneBit = Integer.highestOneBit(oldCallMask);
        if (highestOneBit == 0) {
            //第一个check， 直接return
            return;
        }
        if (highestOneBit > serialBit) {
            throw new TestException("执行顺序错误 %d --> %d", latestSerial(highestOneBit), latestSerial(serialBit));
        }
    }
}
