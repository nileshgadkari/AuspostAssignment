package com.nilesh.seekjob.assignment.util;

public class StringUtil {
    public static boolean isBlank(String str) {
        if(str == null || str.isBlank()) {
            return true;
        }
        return false;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }
}
