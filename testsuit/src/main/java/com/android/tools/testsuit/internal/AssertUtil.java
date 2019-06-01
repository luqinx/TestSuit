package com.android.tools.testsuit.internal;

/**
 * @author qinchao
 * @since 2019/5/6
 */
class AssertUtil {


    static <T> boolean equals(T actual, Object expected) {
        return equalsRegardingNull(expected, actual);
    }

    static <T> boolean valueEquals(T actual, Number expected) {
        return actual instanceof Number && ((Number) actual).longValue() == expected.longValue();
    }




    private static boolean equalsRegardingNull(Object expected, Object actual) {
        if (expected == null) {
            return actual == null;
        }

        return isEquals(expected, actual);
    }

    private static boolean isEquals(Object expected, Object actual) {
        return expected.equals(actual);
    }
}
