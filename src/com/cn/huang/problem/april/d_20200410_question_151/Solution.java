/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200410_question_151;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * Given an input string, reverse the string word by word.
 *
 *
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月10日 3:04 下午 huangzuo Exp $
 */
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        String[] strs = s.trim().split(" ");

        Deque<String> dq = new ArrayDeque<>();

        StringBuilder res = new StringBuilder();

        //遇到空格就pop
        for (String str : strs){
            if (!str.equals("")){
                dq.push(str);
            }
        }


        while (dq.size() > 0){
            res.append(dq.pop());
            if (dq.size() != 0 ){
                res.append(" ");
            }
        }

        return res.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("a good   example"));
    }
}
