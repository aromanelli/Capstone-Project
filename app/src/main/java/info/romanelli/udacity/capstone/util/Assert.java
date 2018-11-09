package info.romanelli.udacity.capstone.util;

import android.util.Log;

import org.jetbrains.annotations.Contract;

import java.util.Arrays;

/**
 * <p>
 *     A class that replaces the java keyword {@code assert}, which does not work
 *     well (at all?) in the Android environment.
 * </p><br>
 * <p>
 *     Add "{@code implementation 'org.jetbrains:annotations:16.0.3'}" (changing
 *     the version number to match the latest version) to the build.gradle file,
 *     as the annotations library is not on the classpath by default.
 * </p><br>
 * @see <a href="https://blog.jetbrains.com/idea/2013/10/better-control-flow-analysis-with-contract-annotations-and-intellij-idea-13/">Better Control Flow Analysis with Contract Annotations and IntelliJ</a>
 * @see <a href="https://mvnrepository.com/artifact/org.jetbrains/annotations">JetBrains Java Annotations</a>
 * @author Adrian O. Romanelli
 * @version 1.0
 */
public class Assert {

    public static final String TAG = Assert.class.getSimpleName();

    /*
    implementation 'org.jetbrains:annotations:16.0.3'
     */

    @Contract("false -> fail")
    public static void that(boolean condition) throws AssertionError {
        Assert.that(condition, null);
    }

    @Contract("false, _ -> fail")
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
