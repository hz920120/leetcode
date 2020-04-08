/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200408_question_74;

/**
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月08日 10:08 下午 huangzuo Exp $
 */
public class Solution {

    //二分法
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0){return false;}
        int m = matrix.length;
        int n = matrix[0].length;

        int dx1 = 0;
        int dy1 = 0;
        int dx2 = m-1;
        int dy2 = n-1;

        for (int i = 0; i < (m*n)/2 + 1; i++) {
            if (matrix[dx1][dy1] == target || matrix[dx2][dy2] == target){
                return true;
            }
            if (dx1 >= dx2 && dy1 >= dy2){
                return false;
            }
            dx1++;
            dx2--;
            if (dx1 >= m){
                dx1 = 0;
                dy1++;
                dx2 = m-1;
                dy2--;
            }
        }

        return false;
    }

}
