/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.string;

import java.util.*;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 * @author huangzuo
 * @version : firstUniqChar.java, v 0.1 2020年05月06日 11:53 下午 huangzuo Exp $
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int len = s.length();
        if (len == 0){return -1;}
        if (len == 1){return 0;}
        List<Character> list = new ArrayList<>();
        List<Character> repeat = new ArrayList<>();
        List<Character> all = new ArrayList<>();
        char[] ele = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            all.add(ele[i]);
            if (repeat.contains(ele[i])){
                continue;
            }
            if (!list.contains(ele[i])){
                list.add(ele[i]);
            }else {
                list.remove(list.indexOf(ele[i]));
                repeat.add(ele[i]);
            }
        }

        return list.isEmpty() ? -1 : all.indexOf(list.get(0));
    }

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        System.out.println(firstUniqChar.firstUniqChar("cc"));
    }
}
