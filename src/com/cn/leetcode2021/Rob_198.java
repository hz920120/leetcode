package com.cn.leetcode2021;

import java.util.HashMap;

/**
 * @author HUANG Zuo
 * @version create_time：2021-10-05 10:29:31
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class Rob_198 {

    HashMap<Integer, Integer> trueMap = new HashMap<>();
    HashMap<Integer, Integer> falseMap = new HashMap<>();
    public int rob(int[] nums) {
        return process(false, 0, nums, 0);
    }

    //返回金额
    private int process(boolean pre, int currIndex, int[] houses, int amount) {

        //base case, 最后一个房子
         if (currIndex == houses.length - 1) {
            return pre ? amount : amount + houses[currIndex];
        }

        if (pre) {
            if (falseMap.containsKey(currIndex)) return falseMap.get(currIndex);
            int trueAmount = process(false, currIndex + 1, houses, amount);
            //当前房间没有偷钱时的最大金额
            falseMap.put(currIndex, trueAmount);
            return trueAmount;
        } else {
            int yes = trueMap.containsKey(currIndex) ? trueMap.get(currIndex) : process(true, currIndex + 1, houses, amount + houses[currIndex]);
            trueMap.put(currIndex, yes);
            int no = falseMap.containsKey(currIndex) ? falseMap.get(currIndex) : process(false, currIndex + 1, houses, amount);
            falseMap.put(currIndex, no);
            return Math.max(yes, no);
        }
    }

    public static void main(String[] args) {
        Rob_198 rob_198 = new Rob_198();
        //114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240
        System.out.println(rob_198.rob(new int[]{2,7,9,3,1,24,1,5,123,51,0}));
    }
}
