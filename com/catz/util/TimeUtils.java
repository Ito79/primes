/**
 * Class with util functions about Time
 * Author: Carlos Palacios (@Ito_pr)
 */
package com.catz.util;

public class TimeUtils {
    public static long getTime() {
        return System.currentTimeMillis();
    }

    public static void showElapsedTime(long startTime, long endTime) {
        System.out.println("t = "+ ( endTime - startTime ) +"ms");
    }
}
