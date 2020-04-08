/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.interview.d_20200407_interview_01_07;

import java.util.Arrays;

/**
 *
 * Given an image represented by an N x N matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 *
 *  
 *
 * Example 1:
 *
 * Given matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * Rotate the matrix in place. It becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * Example 2:
 *
 * Given matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * Rotate the matrix in place. It becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月07日 5:55 下午 huangzuo Exp $
 */
public class Solution {

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        //沿对角线先折叠一次
        int temp;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i < j){
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        if (length%2 != 0){
            for (int i = 0; i < length / 2; i++) {
                for (int j = 0; j < length ; j++) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[i][i+length/2+1];
                    matrix[i][i+length/2+1] = temp;
                }
            }
        }
        //偶数
//        if (length%2 == 0){
//            for (int i = 0; i < length / 2; i++) {
//                for (int j = 0; j < length / 2; j++) {
//
//                }
//            }
//        }
    }

    public static void main(String[] args) {
        System.out.println();
    }

}
