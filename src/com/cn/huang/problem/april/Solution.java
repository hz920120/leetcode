/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月30日 6:29 下午 huangzuo Exp $
 */
public class Solution {
    public boolean isHappy(int n) {
        //key存平方和，例如82；value存数 19
        Map<Integer, Integer> map = new HashMap<>();
        while (true){
            int sum = getSum(n);
            if (sum == 1){
                return true;
            }else if (map.containsKey(sum)){
                return false;
            }else {
                map.put(sum,n);
                n = sum;
            }
        }
    }

    private int getSum(Integer num){
        char[] nums = String.valueOf(num).toCharArray();
        int res = 0;
        for (int i : nums){
            res += Math.pow(i-'0',2);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
    }
}
