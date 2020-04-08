/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.interview.d_20200408_interview_13;


/**
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月08日 10:13 上午 huangzuo Exp $
 */
public class Solution {

//    int[] rx = new int[]{0,1};
//    int[] ry = new int[]{1,0};
//    int[] lx = new int[]{0,-1};
//    int[] ly = new int[]{-1,0};

    public int movingCount(int m, int n, int k) {
        if (k == 0){
            return 1;
        }
        if (k >= m+n){
            return m+n;
        }
        //左下角指针和右上角指针一起走
        int leftPointer = 0;
//        int rigthPointer = m+n;

        int count = 1;
        for (int i = 1; i < m + n; i++) {
            int move = i % 2;
            //i为奇数就横着走
            if (move == 1){
                if (sumInteger(leftPointer++) <= k){
                    count += 2;
                }else {
                    return count;
                }
            }
            //i为偶数就竖着走
            else {
                if (sumInteger(leftPointer++) <= k){
                    count += 1;
                }else {
                    return count;
                }
            }
        }
        return count;
    }


    private int sumInteger(Integer i) {
        int res = 0;
        for (char ele : i.toString().toCharArray()){
            res += Integer.valueOf(String.valueOf(ele));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(2,3,1));
//        int i =1;
//        System.out.println(i == i);
//        System.out.println(i);

    }
}
