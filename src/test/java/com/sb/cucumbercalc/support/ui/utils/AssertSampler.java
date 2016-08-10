package com.sb.cucumbercalc.support.ui.utils;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * <p>This class provides utilities to check the result of some asynchronous processes, by sampling
 * an assertion until it becomes true.</p>
 * <p>
 * <p>"Listening for events is the fastest and most reliable way to synchronize your
 * tests with an asynchronous system.
 * [...]
 * When it isn’t possible to listen to events from the system, the next best option
 * is to repeatedly poll the system for the state change you’re expecting. If it
 * doesn’t appear within a certain timeout, you give up and fail the test."
 * (The Cucumber for Java Book - Rose, Wynne & Hellesoy - 2015)</p>
 * <p>
 * Example :
 * <pre>
 *     import static org.hamcrest.Matchers.*;
 *     [...]
 *     AssertSampler.pollUntilResultOf(new Sample<String>() {
 *         public String test() {
 *             return service.getState();
 *         }
 *     }, is(expected));
 * </pre>
 *
 * @author sboursault on 20/02/16.
 */
public class AssertSampler {

    public static final long DEFAULT_TIMEOUT_MILLISECS = 2000;
    public static final long DEFAULT_POLLING_INTERVAL_MILLISECS = 200;

    public static <T> void pollUntil(final Sample<T> callable) {
        pollUntil(callable, DEFAULT_TIMEOUT_MILLISECS);
    }

    public static <T> void pollUntil(final Sample<T> callable,
                                     final long timeoutMillisecs) {
        pollUntil(callable, timeoutMillisecs, DEFAULT_POLLING_INTERVAL_MILLISECS);
    }

    public static <T> void pollUntil(final Sample<T> callable,
                                     long timeoutMillisecs, final long pollIntervalMillisecs) {
        AssertionError error;
        boolean testFails;

        do {
            error = null;

            try {
                Thread.sleep(pollIntervalMillisecs);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
            timeoutMillisecs -= pollIntervalMillisecs;

            try {
                callable.test();
            } catch (final AssertionError assertionError) {
                error = assertionError;
            }

            testFails = error != null;

        } while (testFails && timeoutMillisecs > 0);

        if (testFails) {
            throw error;
        }
    }

    private static int testVar = 0;

    public static void main(final String[] args) {
        pollUntil(new Sample<Integer>() {
            public void test() {
                assertThat(3, is(3));
            }
        });
        pollUntil(new Sample<Integer>() {
            public void test() {
                testVar++;
                assertThat(testVar, is(3));
            }
        });
        pollUntil(new Sample<Integer>() {
            public void test() {
                assertThat(5, is(2));
            }
        });
    }

    public interface Sample<T> {
        void test();
    }
}