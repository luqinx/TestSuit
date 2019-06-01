package com.android.tools.testsuit;

/**
 * @author qinchao
 * @since 2019/4/15
 */
public class CallCountChecker implements IChecker {

    int callMask = 0;

    @Override
    public void checkCondition(ConditionImpl condition) {
        callMask |= 1 << (condition.serialNo - 1);
    }

    @Override
    public void checkResult(int count) {
        if (Integer.bitCount(callMask) != count) {
            int mask = callMask;
            StringBuilder builder = new StringBuilder();
            while (Integer.bitCount(mask) > 0) {
                int serial = latestSerial(mask);
                builder.append(serial).append(" --> ");
                int _latestBit = ~Integer.lowestOneBit(mask);
                mask &= _latestBit;
            }
            builder.append("end");
            throw new TestException("%d/%d serials are called, %s", Integer.bitCount(callMask), count, builder.toString());
        }
    }


    static int latestSerial(int i) {
        return Integer.numberOfTrailingZeros(Integer.lowestOneBit(i)) + 1;
    }
}
