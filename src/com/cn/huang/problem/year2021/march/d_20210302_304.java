/*
 * Miya.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.cn.huang.problem.year2021.march;

/**
 * @author huangzuo
 * @version : d_20210301_303.java, v 0.1 2021年03月01日 10:52 下午 huangzuo Exp $
 */
public class d_20210302_304 {

    int[][] sum;

    public d_20210302_304(int[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        sum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;col1++;row2++;col2++;
        return sum[row2][col2] - sum[row1-1][col2] - sum[row2][col1 - 1] + sum[row1-1][col1 - 1];
    }
}
