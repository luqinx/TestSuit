package com.android.tools.testsuit;

/**
 * @author qinchao
 * @since 2019/4/15
 */
public class Checker {

    public static class Builder {

        boolean withPriority;

        String tag;

        public Builder(String tag) {
            this.tag = tag;
        }

        public Builder withPriority() {
            withPriority = true;
            return this;
        }

        public Checker build() {
            if (tag == null) {
                return new Checker(this);
            }
            Checker checker = CheckerManager.getChecker(tag);
            if (checker == null) {
                checker = new Checker(this);
            }
            return checker;
        }
    }

    private IChecker mDelegate;

    private Builder mBuilder;

    private ConditionImpl mCondition;


    private Checker(Builder builder) {
        this.mBuilder = builder;
        if (mBuilder.withPriority) {
            mDelegate = new CallPriorityChecker();
        } else {
            mDelegate = new CallCountChecker();
        }
        mCondition = new ConditionImpl(mDelegate);
        CheckerManager.putChecker(mBuilder.tag, this);
    }

    public void shouldNotCall() {
        mCondition.shouldNotCall();
    }

    public void shouldCall() {
        mCondition.shouldCall(1);
    }

    public void shouldCall(int serial) {
        if (serial > 31) {
            throw new TestException("serial param should from 1 to 31.");
        }
        mCondition.shouldCall(serial);
    }

    public void check() {
        check(1);
    }

    public void check(int count) {
        mDelegate.checkResult(count);
        CheckerManager.removeChecker(mBuilder.tag);
    }

    public Checker reset() {
        CheckerManager.removeChecker(mBuilder.tag);
        return new Checker(mBuilder);
    }
}
