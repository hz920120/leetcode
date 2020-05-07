/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.string;

import java.util.HashMap;
import java.util.Map;

/**
 *  有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 *
 * @author huangzuo
 * @version : IsAnagram.java, v 0.1 2020年05月07日 3:20 下午 huangzuo Exp $
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            Integer count = sMap.get(sChar[i]);
            if (count == null) {
                sMap.put(sChar[i], 1);
            }else {
                sMap.put(sChar[i], count+1);
            }
        }

        char[] tChar = t.toCharArray();
        for (int i = 0; i < tChar.length; i++) {
            Integer count = sMap.get(tChar[i]);
            if (count == null){
                return false;
            }else {
                if((count-1) == 0) {
                    sMap.remove(tChar[i]);
                }else {
                    sMap.put(tChar[i],count-1);
                }
            }
        }

        return sMap.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        System.out.println(isAnagram.isAnagram("rat","car"));
    }
}
