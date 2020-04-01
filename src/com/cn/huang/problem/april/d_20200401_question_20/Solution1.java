/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200401_question_20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzuo
 * @version : Solution1.java, v 0.1 2020年04月02日 12:26 上午 huangzuo Exp $
 */
public class Solution1 {

    private static final HashMap<Character,Character> map = new HashMap<Character,Character>(){{
        put(')','(');
        put('}','{');
        put(']','[');
    }};

    public boolean isValid(String s) {

        if (s== null || s.length() == 0){
            return true;
        }
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            if (c==40 || c==91 || c==123){
                dq.push(c);
            }else {
                if (dq.size()!=0 && dq.peek().equals(map.get(c))){
                    System.out.println(dq.pop());
                }else return false;
            }
        }

        return dq.size() == 0;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isValid("()"));
    }
}
