/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200402_question_289;

/**
 *
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 *
 * Example:
 *
 * Input:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * Output:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月02日 11:48 下午 huangzuo Exp $
 */
public class Solution {
    int m;
    int n;
    //周围的8个细胞
    int[] dx = {-1,0,1,-1,1,-1,0,1};
    int[] dy = {1,1,1,0,0,-1,-1,-1};
    int[][] board;

    public void gameOfLife(int[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = countAlive(i,j);
                //此轮活着，下轮活着，有影响 ： 1
                //此轮活着，下轮死了，有影响 ： 3
                //如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
                if (board[i][j] == 0 && cnt == 3) board[i][j] = 2;
                //如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
                if (board[i][j] == 1 && (cnt == 3 || cnt == 2)) board[i][j] = 3;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int countAlive(int x,int y){
        int res = 0;
        for (int i = 0; i < 8; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];
            if (x1<0 || y1<0 || x1 >= m || y1 >= n) continue;
            //此轮死了，下轮死了，无影响 ： 0
            //此轮活着，下轮活着，有影响 ： 1
            //此轮活着，下轮死了，有影响 ： 3
            //此轮死着，下轮活了，无影响 ： 2
            res += (board[x1][y1] & 1);
        }
        return res;
    }

}
