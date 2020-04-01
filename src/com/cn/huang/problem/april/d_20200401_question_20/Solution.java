/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200401_question_20;

/**
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月01日 10:54 下午 huangzuo Exp $
 */
public class Solution {

    public boolean isValid(String s) {

        if (s.contains("()")){
            return isValid(s.replace("()",""));
        }

        if (s.contains("{}")){
            return isValid(s.replace("{}",""));
        }

        if (s.contains("[]")){
            return isValid(s.replace("[]",""));
        }

        if ("".equals(s)){
            return true;
        }else {
            return false;
        }



    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("{[[()]]}"));
//        System.out.println('(' == 40);
    }
}