/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200420_question_200;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月20日 8:42 下午 huangzuo Exp $
 */
public class Solution {
    private static char[][] ori;
    private static int m;
    private static int n;
    private static int[] dx = new int[]{-1,1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};

    public int numIslands(char[][] grid) {
        if (grid.length == 0){
            return 0;
        }
        //网格的纵轴
        this.m = grid.length;
        if (grid[0].length == 0){
            return 0;
        }
        //网格的横轴
        this.n = grid[0].length;
        this.ori = grid;

        //岛屿数量
        int islands = 0;

        //遍历每一个点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //如果岛屿为1且没有被访问过，则开始沿着这个1寻找岛屿的边界
                if (grid[i][j] == '1' && grid[i][j] != '2') {
                    dfs(i,j);
                    //寻找一次即为一个岛屿，+1
                    islands ++ ;
                }
            }
        }
        return islands;
    }

    private void dfs(int x,int y){
        //如果不为0，则继续遍历该点的左(-1,0)、右(1,0)、上(0,-1)、下(0,1)
        for (int k = 0; k < 4; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];
            //越界的点或者已访问过的点忽略，直接访问下一个点
            if (newX < 0 || newY < 0 || newX >= m || newY >= n || ori[newX][newY] == 2 ){
                continue;
            }else if (ori[newX][newY] == '0'){//如果当前点的值为0，标记并访问下一个点
                ori[newX][newY] = '2';
                continue;
            }else if (ori[newX][newY] == '1') {//如果当前点的值为1，先标记该点，然后遍历该点的上下左右，即DFS
                ori[x][y] = '2';
                dfs(newX, newY);
                continue;
            }
        }
        //循环完上下左右，则标记该点为已访问
        ori[x][y] = '2';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char a = '1';
        char b = '0';

        System.out.println(solution.numIslands(new char[][]{
                {a},{a}
        }));
    }
}

