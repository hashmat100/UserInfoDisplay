package com.sample11.main.log;

/**
 * Created by Ashmath Khan on 24-02-2018.
 */

public class Log {
    private static String TAG = "UserInfoDisplay";

    public static int debug(String msg) {

        String where = "";
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        if (ste.length > 3 && ste[3] != null) {
            where = "(" + ste[3].getFileName()+ ":" + ste[3].getLineNumber() + ")" + " ";
        }

        return android.util.Log.d(TAG, where + msg);
    }

    public static int info(String msg) {
        String where = "";
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        if (ste.length > 3 && ste[3] != null) {
            where = "(" + ste[3].getFileName()+ ":" + ste[3].getLineNumber() + ")" + " ";
        }

        return android.util.Log.i(TAG, where + msg);
    }

    public static int warning(String msg) {
        String where = "";
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        if (ste.length > 3 && ste[3] != null) {
            where = "(" + ste[3].getFileName()+ ":" + ste[3].getLineNumber() + ")" + " ";
        }

        return android.util.Log.w(TAG, where + msg);
    }

    public static int error(String msg) {
        String where = "";
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        if (ste.length > 3 && ste[3] != null) {
            where = "(" + ste[3].getFileName()+ ":" + ste[3].getLineNumber() + ")" + " ";
        }

        return android.util.Log.e(TAG, where + msg);
    }

    public static int verbose(String msg) {
        String where = "";
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        if (ste.length > 3 && ste[3] != null) {
            where = "(" + ste[3].getFileName()+ ":" + ste[3].getLineNumber() + ")" + " ";
        }

        return android.util.Log.v(TAG, where + msg);
    }
}
