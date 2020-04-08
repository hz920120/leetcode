/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.interview.d_20200408_interview_04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *  
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 *  
 *
 * 限制：
 *
 * 0 <= n <= 1000
 *
 * 0 <= m <= 1000
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月08日 9:48 下午 huangzuo Exp $
 */
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length ==0 || matrix[0].length == 0) {return false;}
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        while (queue.size() > 0){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if (x >= n || y >= m || visited[x][y]) {continue;}
            if (matrix[x][y] == target) {return true;}
            visited[x][y] = true;
            queue.add(new int[]{x,y+1});
            queue.add(new int[]{x+1,y});
        }

        return false;
    }
}
