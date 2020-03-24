/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.march.d_20200312_question_205;

import java.util.HashMap;

/**
 * @author huangzuo
 * @version : Solution1.java, v 0.1 2020年03月13日 5:57 下午 huangzuo Exp $
 */
public class Solution1 {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }else{
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("aa","ac"));
    }
}
