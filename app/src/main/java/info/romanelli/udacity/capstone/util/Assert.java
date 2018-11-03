package info.romanelli.udacity.capstone.util;

import android.util.Log;

import java.util.Arrays;

public class Assert {

    public static final String TAG = Assert.class.getSimpleName();

    // TODO figure out why I can't get the 'assert' keyword to work correctly!

    public static void that(boolean condition) throws AssertionError {
        Assert.that(condition, null);
    }

    public static void that(boolean condition, String message) throws AssertionError {
        if (!condition) {
            AssertionError ae;
            if (message == null) {
                ae = new AssertionError();
                message = getCaller(ae);
            } else {
                ae = new AssertionError(message);
                message += " " + getCaller(ae);
            }
            Log.println(Log.ASSERT, TAG, message);
            throw ae;
        }
    }

    private static String getCaller(final AssertionError ae) {
        for (StackTraceElement ste : ae.getStackTrace()) {
            if (!ste.getClassName().equals(Assert.class.getName())) {
                return ste.toString();
            }
        }
        return Arrays.asList(ae.getStackTrace()).toString();
    }

}
