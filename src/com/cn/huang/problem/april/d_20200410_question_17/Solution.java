/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200410_question_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    private boolean[][] visited;
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

        char[] nums = digits.toCharArray();
        visited = new boolean[10][10];
        for (char x : nums){
            for (char y : nums){
                split(x,y);
            }
        }
        return res;
    }

    private void split(char cx,char cy){
        int x = cx-'0';
        int y = cy-'0';
        if (visited[x][y] || visited[y][x] || x==y){return;}
        dfs(x,y);
        visited[x][y] = true;
        visited[y][x] = true;
    }


    private void dfs(int left,int right) {
        char[] lefts = map.get(left).toCharArray();
        char[] rights = map.get(right).toCharArray();
        for (char l : lefts){
            for (char r : rights){
                StringBuilder sb = new StringBuilder();
                sb.append(l).append(r);
                res.add(sb.toString());
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.letterCombinations("234"));
//        System.out.println('2');
    }
}
