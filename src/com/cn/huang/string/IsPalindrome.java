/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.string;

/**
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 *
 * @author huangzuo
 * @version : IsPalindrome.java, v 0.1 2020年05月07日 4:02 下午 huangzuo Exp $
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0){return true;}
        s = s.toLowerCase();
        int a = 'a';
        int z = 'z';
        int zero = '0';
        int nine = '9';
        char[] ele = s.toCharArray();
        for (int i = 0; i < ele.length; i++) {
            //ACSII码不在a-z的范围内
            if (!(ele[i] >= zero && ele[i] <= nine) && !(ele[i] >= a && ele[i] <= z)){
                s = s.replace(ele[i],' ');
            }
        }
        s = s.replace(" ","");
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        if (s.equals(sb.toString())){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        isPalindrome.isPalindrome("0P");
    }
}
