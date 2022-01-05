package com.cn.leetcode2022;

import java.util.Arrays;

/**
 * @author HUANG Zuo
 * @version create_time：2022-01-01 18:42:44
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class Construct2DArray_2022 {

    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        if (m * n != len) {
            return new int[0][0];
        }

        int[][] res = new int[m][n];
        int r = 0;

        for (int i = 0; i < m; i++) {
            int[] row = Arrays.copyOfRange(original, i * n, (i+1) * n);
//            System.arraycopy(original, i * n, row, 0, n);
            res[r] = row;
            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        Construct2DArray_2022 construct2DArray_2022 = new Construct2DArray_2022();
        int[] arr = new int []{1,2,3,5};
        construct2DArray_2022.construct2DArray(arr, 2,2);
    }

}
