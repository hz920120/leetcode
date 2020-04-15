/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200415_question_542;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 *  
 *
 * Example 1:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 * Example 2:
 *
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,1,1]]
 *
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,2,1]]
 *  
 *
 * Note:
 *
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月15日 10:01 上午 huangzuo Exp $
 */
public class Solution {

    private int[][] matrix;
    private int x;
    private int y;

    public int[][] updateMatrix(int[][] matrix) {

        if (matrix.length == 0){return matrix;}
        if (matrix[0].length == 0){return matrix;}
        this.matrix = matrix;

        this.x = matrix.length;
        this.y = matrix[0].length;

        int[][] res = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                res[i][j] = search(i,j,0);
            }
        }

        return res;
    }

    private int search(int len,int dep,int distance){
        if (len >= x || dep >= y || len < 0 || dep < 0){return 20000;}
        if (matrix[len][dep] == 0){return distance;}
        int rightdown = Math.min(search(len+1,dep,distance+1),search(len,dep+1,distance+1));
        int leftup = Math.min(search(len-1,dep,distance+1),search(len,dep-1,distance+1));
        return Math.min(rightdown,leftup);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}}));
    }

}
