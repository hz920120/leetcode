/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package problem.march.d_20200317_question_1160;

/**
 * @author huangzuo
 * @version : Solution1.java, v 0.1 2020年03月17日 2:47 下午 huangzuo Exp $
 */
public class Solution1 {
    public static int countCharacters(String[] words, String chars) {
        //new一个int[26]的数组用于存放chars中字母出现的次数
        int[] charsInts = new int[26];
        for (char c : chars.toCharArray()){
            charsInts[c-'a']++;
        }

        int length = 0;
        a : for (String word : words) {
            //new一个int[26]的数组用于存放当前word中字母出现的次数
            int[] wordInts = new int[26];
            for (char c : word.toCharArray()){
                wordInts[c - 'a']++;
            }

            //从charsInts找当前word是否满足条件，不满足的直接跳到下一个单词
            for (char c : word.toCharArray()){
                if (charsInts[c-'a'] == 0){
                    continue a;
                }
                if (charsInts[c-'a'] < wordInts[c-'a']){
                    continue a;
                }
            }
            System.out.println("the word is : " + word);
            //满足条件的单词长度加上
            length += word.length();
        }

        //新建一个对象存储chars中a-z的数量
        //循环words里的单词，每个单词循环过程中统计单词个数并判断map中该单词的个数是否大于等于该单词中单词的个数

        return length;
    }

    public static void main(String[] args) {
        System.out.println(countCharacters(new String[]{"cat","bt","hat","tree"},"atach"));

    }
}
