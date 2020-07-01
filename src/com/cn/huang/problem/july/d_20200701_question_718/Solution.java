/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.july.d_20200701_question_718;

/**
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 *
 * @author huangzuo
 * @version : d_20200701_question_718.java, v 0.1 2020年07月01日 11:32 下午 huangzuo Exp $
 */
public class Solution {
    private int[][] matrix;
    public int findLength(int[] A, int[] B) {

        //左上有数字则+1，没有则是0
        int len = A.length;
        int hei = B.length;
        //初始化矩阵
        matrix = new int[len][hei];
        //矩阵中的最大值
        int max = 0;
        //开始遍历
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < hei; j++) {
                if (A[i] == B[j]) {
                    //找左上角数字+1
                    int temp;
                    max = (temp = (findLeftConer(i-1,j-1) + 1)) > max ? temp : max;
                    matrix[i][j] = temp;
                }
            }
        }
        return max;
    }

    private int findLeftConer(int x,int y){
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length){
            return 0;
        }else {
            return matrix[x][y];
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,2,1};
        int[] B = new int[]{3,2,1,4,7};
        Solution solution = new Solution();
        System.out.println(solution.findLength(A,B));
    }
}
