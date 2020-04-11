/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200410_question_151;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author huangzuo
 * @version : Solution2.java, v 0.1 2020年04月10日 3:28 下午 huangzuo Exp $
 */
public class Solution2 {
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



}
