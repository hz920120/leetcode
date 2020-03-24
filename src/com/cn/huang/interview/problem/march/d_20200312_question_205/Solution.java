/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.interview.problem.march.d_20200312_question_205;

import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 *
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月12日 6:12 下午 huangzuo Exp $
 */
public class Solution {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
//        if (s.hashCode() > t.hashCode()){
//            return isIsomorphic(t,s);
//        }
        HashMap sKey = getMap(s,t);
        HashMap tKey = getMap(t,s);
        if (sKey.size() != tKey.size()){
            return false;
        }
        String res = "";
        for (char ch : s.toCharArray()){
            res += sKey.get(ch);
        }
        if (!t.equals(res)){
            return false;
        }
        else {
            return true;
        }
    }

    private static HashMap getMap(String s,String t){
        HashMap map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return map;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(isIsomorphic("foo","bar"));

        System.out.println((System.currentTimeMillis() - start) / 1000 /1000 + "毫秒");
    }
}
