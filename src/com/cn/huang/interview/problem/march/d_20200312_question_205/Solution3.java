/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.interview.problem.march.d_20200312_question_205;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzuo
 * @version : Solution3.java, v 0.1 2020年03月14日 12:21 上午 huangzuo Exp $
 */
public class Solution3 {
    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int indexS = mapS.getOrDefault(s.charAt(i), -1);
            int indexT = mapT.getOrDefault(t.charAt(i), -1);

            if (indexS != indexT) {
                return false;
            }

            mapS.put(s.charAt(i), i);
            mapT.put(t.charAt(i), i);
        }

        return true;
    }

    public static void main(String[] args) {
        isIsomorphic("add","egg");
    }
}
