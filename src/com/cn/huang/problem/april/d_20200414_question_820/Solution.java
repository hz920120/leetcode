/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200414_question_820;

import java.util.Arrays;

/**
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月28日 12:25 上午 huangzuo Exp $
 */
public class Solution {

    public int minimumLengthEncoding(String[] words) {

        int len = words.length;
        String[] reverseList = new String[len];

        for (int i = 0; i < len; i++) {
            String reverseWord = new StringBuilder(words[i]).reverse().toString();
            reverseList[i] = reverseWord;
        }

        Arrays.sort(reverseList);

        int res = 0;
        for (int i = 0; i < len; i++) {
            if (i < len-1 && reverseList[i+1].startsWith(reverseList[i])){

            }else {
                res += reverseList[i].length() + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minimumLengthEncoding(new String[]{"time", "me", "lime", "sometime", "hell", "shell"});
    }
}
