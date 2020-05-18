/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * @author huangzuo
 * @version : StrStr.java, v 0.1 2020年05月18日 10:07 上午 huangzuo Exp $
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        if ("".equals(needle)){
            return 0;
        }
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();
        List<Character> haystackList = new ArrayList<>();
        for (int i = 0; i < hay.length; i++) {
            haystackList.add(hay[i]);
        }

        int head = nee[0];
        a : for (int i = 0; i < haystackList.size(); i++) {
            int m = i;
            if (head == haystackList.get(i)){
                b : for (int j = 1; j < nee.length; j++) {
                    if (m+1 > haystackList.size() -1){
                        return -1;
                    }
                    if (nee[j] == haystackList.get(++m)){
                        continue b;
                    }else {
                        continue a;
                    }
                }
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr("mississippi","mississippi"));
    }
}
