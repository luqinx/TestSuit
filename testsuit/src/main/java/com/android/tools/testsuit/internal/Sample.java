package com.android.tools.testsuit.internal;

import org.junit.Assert;

/**
 * @author qinchao
 * @since 2019/5/6
 */
public class Sample {

    public static <T> SampleBegin<T> of(T target) {
        return new SampleBegin<>(target);
    }

    public static class SampleBegin<T> extends AssertsImpl<T> {

        private T target;

        private boolean debug = false;

        SampleBegin(T target) {
            super(null, target);
            this.target = target;
        }

        public SampleBegin<T> debugOn() {
            debug = true;
            return this;
        }

        @Override
        public String preMessage() {
            return "\n       ";
        }

        @Override
        void asserts(boolean failed) {
            if (failed) {
                SampleNode<T> node = this;
                StringBuilder builder = new StringBuilder();
                builder.append("\n  assert begin: ")
                    .append(String.valueOf(target));
                while (node != null) {
                    builder.append(node.message());
                    node = node.child();
                }
                if (debug) {
                    System.err.println(builder.toString());
                }
                Assert.fail(builder.toString());
            }
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }


}
