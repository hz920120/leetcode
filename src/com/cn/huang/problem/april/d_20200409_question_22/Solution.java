/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200409_question_22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月09日 12:07 上午 huangzuo Exp $
 */
public class Solution {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        String str = "";
        dfs(n,n,str);
        return res;
    }

    private void dfs(int left,int right,String str){
        if (left == 0 && right == 0){
            res.add(str);
            return;
        }

        if (left > 0){
            dfs(left-1,right,str + "(");
        }
        if (right > left){
            dfs(left,right-1,str + ")");
        }
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

}
