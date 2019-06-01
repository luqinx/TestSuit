package com.android.tools.testsuit;

/**
 * @author qinchao
 * @since 2019/4/15
 */
public class TestException extends RuntimeException {
    public TestException() {}

    public TestException(String message, Object... args) {
        super(String.format(message, args));
    }

    public TestException(String message, Throwable t) {
        super(message, t);
    }
}
