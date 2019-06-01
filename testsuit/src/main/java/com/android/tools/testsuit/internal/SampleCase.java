package com.android.tools.testsuit.internal;

import org.hamcrest.Matcher;
import org.junit.Assert;

/**
 * @author qinchao
 * @since 2019/5/4
 */
@SuppressWarnings("unused")
public class SampleCase {

    public static <T> Sample.SampleBegin<T> of(T t) {
        return Sample.of(t);
    }

    public static void assertException(Class<? extends Throwable> exception, Action action) {
        boolean bingoException = false;
        try {
            action.run();
        } catch (Throwable e) {
            bingoException = true;
            assertInstanceOf(e, exception);
        }
        if (!bingoException) {
            fail(exception.getName() + " expected, but not");
        }
    }


    public static void assertInstanceOf(Object object, Class<?> t) {
        if (object == null) {
            fail("null is not a instance of any Class.");
        }
        if (t == null) {
            throw new NullPointerException("Class t should not be null.");
        }
        if (!t.isAssignableFrom(object.getClass())) {
            fail(object.getClass().getName() + " is not a instance of " + t.getName());
        }
    }

    public static void assertNotInstanceOf(Object object, Class<?> t) {
        if (object == null) {
            throw new NullPointerException("object should not be null.");
        }
        if (t == null) {
            throw new NullPointerException("Class t should not be null.");
        }
        if (t.isAssignableFrom(object.getClass())) {
            fail(object.getClass().getName() + " is a instance of " + t.getName());
        }
    }


    //=========================  org.junit.Assert ===============================//
    
    public static  void assertFalse(boolean condition) {
        Assert.assertFalse(condition);
    }

    public static  void assertFalse(String message, boolean condition) {
        Assert.assertFalse(message, condition);
    }
    
    public static  void assertTrue(boolean condition) {
        Assert.assertTrue(condition);
    }

    public static  void assertTrue(String message, boolean condition) {
        Assert.assertTrue(message, condition);
    }

    public static  void assertNotNull(Object object) {
        Assert.assertNotNull(object);
    }

    public static  void assertNotNull(String message, Object object) {
        Assert.assertNotNull(message, object);
    }
    
    public static  void assertNull(Object object) {
        Assert.assertNull(object);
    }
    
    public static  void assertNull(String message, Object object) {
        Assert.assertNull(message, object);
    }
    
    public static  void assertSame(Object expected, Object actual) {
        Assert.assertSame(null, expected, actual);
    }
    
    public static  void assertSame(String message, Object expected, Object actual) {
        Assert.assertSame(message, expected, actual);
    }
    
    public static  void assertNotSame(Object expected, Object actual) {
        Assert.assertNotSame(null, expected, actual);
    }

    public static  void assertNotSame(String message, Object expected, Object actual) {
        Assert.assertNotSame(message, expected, actual);
    }
    
    public static  void assertEquals(Object expected, Object actual) {
        Assert.assertEquals(expected, actual);
    }

    public static  void assertEquals(String message, Object expected, Object actual) {
        Assert.assertEquals(message, expected, actual);
    }

    public static  void assertEquals(long expected, long actual) {
        Assert.assertEquals(expected, actual);
    }

    public static  void assertEquals(String message, long expected, long actual) {
        Assert.assertEquals(message, expected, actual);
    }

    public static  void assertEquals(double expected, double actual, double delta) {
        Assert.assertEquals(expected, actual, delta);
    }

    public static  void assertEquals(String message, double expected, double actual, double delta) {
        Assert.assertEquals(message, expected, actual, delta);
    }

    public static  void assertEquals(float expected, float actual, float delta) {
        Assert.assertEquals(expected, actual, delta);
    }

    public static  void assertEquals(String message, float expected, float actual, float delta) {
        Assert.assertEquals(message, expected, actual, delta);
    }


    public static  void assertNotEquals(Object expected, Object actual) {
        Assert.assertNotEquals(expected, actual);
    }

    public static  void assertNotEquals(String message, Object expected, Object actual) {
        Assert.assertNotEquals(message, expected, actual);
    }

    public static  void assertNotEquals(long expected, long actual) {
        Assert.assertNotEquals(expected, actual);
    }

    public static  void assertNotEquals(String message, long expected, long actual) {
        Assert.assertNotEquals(message, expected, actual);
    }

    public static  void assertNotEquals(double expected, double actual, double delta) {
        Assert.assertNotEquals(expected, actual, delta);
    }

    public static  void assertNotEquals(String message, double expected, double actual, double delta) {
        Assert.assertNotEquals(message, expected, actual, delta);
    }

    public static  void assertNotEquals(float expected, float actual, float delta) {
        Assert.assertNotEquals(expected, actual, delta);
    }

    public static  void assertNotEquals(String message, float expected, float actual, float delta) {
        Assert.assertNotEquals(message, expected, actual, delta);
    }

    public static  <T> void assertThat(T actual, Matcher<? super T> matcher) {
        Assert.assertThat("", actual, matcher);
    }

    public static  <T> void assertThat(String reason, T actual,
                                      Matcher<? super T> matcher) {
        Assert.assertThat(reason, actual, matcher);
    }

    public static  void fail() {
        Assert.fail();
    }

    public static  void fail(String message) {
        Assert.fail(message);
    }
}
