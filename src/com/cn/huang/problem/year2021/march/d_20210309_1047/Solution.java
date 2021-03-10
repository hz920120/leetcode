/*
 * Miya.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.cn.huang.problem.year2021.march.d_20210309_1047;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author huangzuo
 * @version : Solution.java, v 0.1 2021年03月09日 10:36 下午 huangzuo Exp $
 */
public class Solution {
    private char[] chars;

    public String removeDuplicates(String S) {
        if (StringUtils.isBlank(S)) {
            return S;
        }

        if (chars == null) {
            chars = S.toCharArray();
        }

        Deque<Character> deque = new ArrayDeque<>();
        deque.push(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            if (!deque.isEmpty() && chars[i] == deque.peek()) {
                deque.pop();
            } else {
                deque.push(chars[i]);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()) {
            result.append(deque.pop());
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("abbaca"));
    }
}
