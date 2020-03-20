/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package problem.march.d_20200317_question_1160;

import java.util.*;

/**
 * You are given an array of strings words and a string chars.
 *
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 *
 * Return the sum of lengths of all good strings in words.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 *
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation:
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 *
 *
 * Note:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * All strings contain lowercase English letters only.
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月17日 11:04 上午 huangzuo Exp $
 */
public class Solution {
    public static int countCharacters(String[] words, String chars) {

        if (words ==null || chars == null){
            return 0;
        }

        if (words.length == 0 || words.length > 1000){
            return 0;
        }

        //把chars循环1遍，找出各个字母分别有几个，放入map以k-v形式存储
        //循环words里的单词，每个单词循环过程中统计单词个数并判断map中该单词的个数是否大于等于该单词中单词的个数


        //把chars循环1遍，找出各个字母分别有几个，放入map以k-v形式存储
        Map<Character, Integer> charMap = getCount(chars);

        //循环words里的单词，每个单词循环过程中统计单词个数并判断map中该单词的个数是否大于等于该单词中单词的个数
        int length = 0;
        for (String word : words){
            Map<Character, Integer> wordMap = getCount(word);
            boolean isWord = true;
            for (Map.Entry<Character, Integer> wordChar : wordMap.entrySet()){
                if (charMap.get(wordChar.getKey()) == null ){
                    isWord = false;
                    break;
                } else if (charMap.get(wordChar.getKey()) < wordMap.get(wordChar.getKey())){
                    isWord = false;
                    break;
                }
            }
            if (isWord){
                System.out.println("the word is : "+word);
                length += word.length();
            }
        }

        return length;
    }

    private static Map<Character, Integer> getCount(String chars){
        Map<Character, Integer> charMap = new HashMap<>();
        for (char charStr : chars.toCharArray()){
            if (charMap.get(charStr) == null){
                charMap.put(charStr,1);
            }else {
                charMap.put(charStr,charMap.get(charStr)+1);
            }
        }
        return charMap;
    }

    public static void main(String[] args) {
        System.out.println(countCharacters(new String[]{"cat","bt","hat","tree"},"atach"));

//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("o");
//        list.add("t");
//        list.add("a");
//        Collections.sort(list);
//
//        System.out.println("1");
    }
}
