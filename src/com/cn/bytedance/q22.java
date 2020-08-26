/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzuo
 * @version : q22.java, v 0.1 2020年08月25日 11:22 下午 huangzuo Exp $
 */
public class q22 {
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        String str = "";
        dfs(n,n,str);
        return res;
    }

    private void dfs(int left, int right, String str) {
        //返回条件，左右括号都用完
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }

        if (left > 0) {
            dfs(left - 1,right,str+"(");
        }
        if (right > left) {
            dfs(left, right - 1, str+")");
        }
    }

    public static void main(String[] args) {
        q22 q22 = new q22();
        q22.generateParenthesis(3);
    }
}
