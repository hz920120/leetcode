/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200410_question_17;

import java.util.*;

/**
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月10日 3:58 下午 huangzuo Exp $
 */
public class Solution {

    static HashMap<Integer, String> map = new HashMap<>();
    private static List<String> res = new ArrayList<>();
    private HashMap<String, Boolean> visited;
    private Deque<Integer> storage;
    static {
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){return res;}
        char[] chs = digits.toCharArray();
        //存储digits里边的元素
        storage  = new ArrayDeque<>(chs.length);
        for (char ch : chs){
            storage.push(ch - '0');
        }

        ret(storage);
        return null;
    }

    private void ret(Deque<Integer> storage){
        while (storage.size() > 0){

        }
    }

    private void dfs1(String ori,Integer next){
        if (next == null){return;}
        for (char ch : map.get(next).toCharArray()){
            StringBuilder sb = new StringBuilder(ori);
            sb.append(ch);
            if (storage.size() > 0){
                dfs1(sb.toString(),storage.pop());
            }else {
                res.add(sb.toString());
                //剪枝，例如：sb="ad",则"da"也被访问过
            }
        }
    }

    private void cut(String str,String str1){
        if (str.equals("")){return;}
        char[] chs = str.toCharArray();
        for (char ch : chs){

        }

    }


    private void dfs(int left,int right) {
        char[] lefts = map.get(left).toCharArray();
        char[] rights = map.get(right).toCharArray();
        for (char l : lefts) {
            for (char r : rights) {
                StringBuilder sb = new StringBuilder();
                sb.append(l).append(r);
                dfs1(sb.toString(),storage.pop());
            }
        }
    }



    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.letterCombinations("234"));
//        System.out.println('2');
    }
}
