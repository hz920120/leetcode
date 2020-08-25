/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzuo
 * @version : q20.java, v 0.1 2020年08月25日 12:29 上午 huangzuo Exp $
 */
public class q20 {
    private static Map<Character, Character> map = new HashMap<>();
    static {
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
    }
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        if (chars[0] == ')' || chars[0] == ']' || chars[0] =='}' ){
            return false;
        }
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : chars) {
            if (ch == ')' || ch == ']' || ch == '}') {
                if (!deque.isEmpty() && map.get(ch).equals(deque.pop())) {
                    continue;
                } else {
                    return false;
                }
            } else {
                deque.push(ch);
            }
        }
        return deque.isEmpty();
    }
}
