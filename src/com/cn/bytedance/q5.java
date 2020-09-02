/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

/**
 * @author huangzuo
 * @version : q5.java, v 0.1 2020年08月24日 12:21 下午 huangzuo Exp $
 */
public class q5 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        int len = s.length();
        char[] charArray = s.toCharArray();

        int maxLen = 1;
        int start = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validatePalindrome(charArray, i, j)) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start,start+maxLen);
    }

    private boolean validatePalindrome(char[] charArray, int start, int end) {
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
