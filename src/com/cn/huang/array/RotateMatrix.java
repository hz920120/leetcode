/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.array;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * @author huangzuo
 * @version : RotateMatrix.java, v 0.1 2020年05月06日 8:47 下午 huangzuo Exp $
 */
public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int x = matrix.length,y = x;
        if (x == 0){return;}
        boolean[][] isRotate = new boolean[x][y];

        //对角线旋转
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == j) {continue;}
                else {
                    if (isRotate[i][j]){continue;}
                    else {
                        int temp = matrix[i][j];
                        matrix[i][j] = matrix[j][i];
                        matrix[j][i] = temp;
                        isRotate[i][j] = true;
                        isRotate[j][i] = true;
                    }
                }
            }
        }

        //竖直中线对折
        isRotate = new boolean[x][y];
        for (int i = 0; i < x ; i++) {
            for (int j = 0; j < x/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][x-1-j];
                matrix[i][x-1-j] = temp;
            }
        }

        return;
    }
}
