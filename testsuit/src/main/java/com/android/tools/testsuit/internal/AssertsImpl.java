package com.android.tools.testsuit.internal;

/**
 * @author qinchao
 * @since 2019/5/6
 */
public abstract class AssertsImpl<T> extends SampleNode<T> implements IAsserts<T> {


    private StringBuilder message;

    AssertsImpl(SampleNode<T> parent, T t) {
        super(parent, t);
        message = new StringBuilder();
    }


    @Override
    public SampleRst<T> equalsWith(Object expect) {
        message.append("assertEquals(Object) ").append(String.valueOf(expect));
        return newRst(AssertUtil.equals(target(), expect));
    }

    @Override
    public SampleRst<T> equalsWith(int expect) {
        message.append("assertEquals(int) ").append(expect);
        return newRst(AssertUtil.valueEquals(target(), expect));
    }

    @Override
    public SampleRst<T> equalsWith(long expect) {
        message.append("assertEquals(long) ").append(expect);
        return newRst(AssertUtil.valueEquals(target(), expect));
    }

    @Override
    public SampleRst<T> equalsWith(float expect) {
        message.append("assertEquals(float) ").append(expect);
        return newRst(AssertUtil.valueEquals(target(), expect));
    }

    @Override
    public SampleRst<T> equalsWith(double expect) {
        message.append("assertEquals(double) ").append(expect);
        return newRst(AssertUtil.valueEquals(target(), expect));

    }

    @Override
    public SampleRst<T> notEqualsWith(Object expect) {
        message.append("assertNotEquals(Object) ").append(expect);
        return newRst(!AssertUtil.equals(target(), expect));
    }
    @Override
    public SampleRst<T> notEqualsWith(int expect) {
        message.append("assertNotEquals(int) ").append(expect);
        return newRst(!AssertUtil.valueEquals(target(), expect));
    }

    @Override
    public SampleRst<T> notEqualsWith(long expect) {
        message.append("assertNotEquals(long) ").append(expect);
        return newRst(!AssertUtil.valueEquals(target(), expect));
    }

    @Override
    public SampleRst<T> notEqualsWith(float expect) {
        message.append("assertNotEquals(float) ").append(expect);
        return newRst(!AssertUtil.valueEquals(target(), expect));
    }

    @Override
    public SampleRst<T> notEqualsWith(double expect) {
        message.append("assertNotEquals(double) ").append(expect);
        return newRst(!AssertUtil.valueEquals(target(), expect));
    }

    @Override
    public SampleRst<T> isNull() {
        message.append("assertNull ");
        return newRst(target() == null);
    }

    @Override
    public SampleRst<T> notNull() {
        message.append("assertNotNull ");
        return newRst(target() != null);
    }

    @Override
    public SampleRst<T> instanceOf(Class<?> t) {
        message.append("assertInstanceOf ").append(String.valueOf(t));
        if (target() == null) {
            return newRst(false);
        }
        return newRst(t.isAssignableFrom(target().getClass()));
    }

    @Override
    public SampleRst<T> notInstanceOf(Class<?> t) {
        message.append("assertNotInstanceOf ").append(String.valueOf(t));
        if (target() == null) {
            return newRst(false);
        }
        return newRst(!t.isAssignableFrom(target().getClass()));
    }

    @Override
    public SampleRst<T> sameWith(Object object) {
        message.append("assertSame ").append(String.valueOf(object));
        return newRst(target() == object);
    }

    @Override
    public SampleRst<T> notSame(Object object) {
        message.append("assertNotSame ").append(String.valueOf(object));
        return newRst(target() != object);
    }

    @Override
    public SampleRst<T> assertTrue() {
        message.append("assertTrue ");
        return newRst(target() instanceof Boolean && (Boolean) target());
    }

    @Override
    public SampleRst<T> assertFalse() {
        message.append("assertFalse ");
        return newRst(target() instanceof Boolean && !(Boolean) target());
    }

    private SampleRst<T> newRst(boolean notFailed) {
        if (!notFailed) {
            message.append(" failed");
        } else {
            message.append(" --");
        }
        return new SampleRst<>(this, notFailed);
    }

    @Override
    String optMessage() {
        return message.toString();
    }

    abstract String preMessage();

    @Override
    public String message() {
        return preMessage() + " " + message;
    }

    @Override
    void asserts(boolean failed) {
        parent().asserts(false);
    }
}
