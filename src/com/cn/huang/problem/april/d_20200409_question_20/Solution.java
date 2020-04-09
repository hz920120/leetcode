/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200409_question_20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月09日 10:21 下午 huangzuo Exp $
 */
public class Solution {

    private static HashMap<Character, Character> map = new HashMap<>();
    static  {
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
    }

    public boolean isValid(String s) {
        if (s== null || s.length() == 0){return true;}
        Deque<Character> dq = new ArrayDeque<>();
        char[] chs = s.toCharArray();
        if (chs[0] == ')' || chs[0] == '}' || chs[0] == ']'   ){return false;}
        for (char ch : chs){
            if (ch == ')' || ch == '}' || ch == ']')
            {
                if (dq.size() > 0 && map.get(ch).equals(dq.pop())){
                    continue;
                }else return false;
            }else {
                dq.push(ch);
            }
        }

        return dq.size() == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("[])"));
    }
}
