/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.march.d_20200319_question_409;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 * tips:
 * a word, phrase, or sequence that reads the same backward as forward, e.g., madam or nurses run.
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月19日 10:04 上午 huangzuo Exp $
 */
public class Solution {

    public static int longestPalindrome(String s) {

        if (s !=null && s.trim().length() == 1){
            return 1;
        }

//        int[] charInt = new int[60];
        Map<Character,Integer> charMap = new HashMap<>();
        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length ; i++){
//            charInt[chars[i] - 'A'] += 1;
//        }
        for (char ch : chars){
            if (charMap.get(ch) == null){
                charMap.put(ch,1);
            }else {
                charMap.put(ch,charMap.get(ch) + 1);
            }
        }

        int length = 0;
        boolean hasMiddle = true;
        for (Map.Entry<Character, Integer> ch : charMap.entrySet()){

            if (ch.getValue() % 2 == 0){
                length += ch.getValue();
            }
            if (ch.getValue() % 2 == 1){
                if (hasMiddle == true) {
                    length += ch.getValue();
                    hasMiddle = false;
                }else {
                    length += (ch.getValue() - 1);
                }

            }
        }


        return length;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
//        System.out.println('z'-'A');
    }
}
