/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

/**
 * @author huangzuo
 * @version : q200.java, v 0.1 2020年08月25日 10:18 下午 huangzuo Exp $
 */
public class q200 {

    private final static int[] M = new int[]{-1,1,0,0};
    private final static int[] N = new int[]{0,0,1,-1};
    private int X;
    private int Y;
    private char[][] ori;

    public int numIslands(char[][] grid) {
        if (grid == null){
            return 0;
        }
        if (grid.length == 0) {
            return 0;
        }
        this.ori = grid;
        //纵轴
        int y = grid[0].length;
        this.Y = y;
        //横轴
        int x = grid.length;
        this.X = x;
        int res = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == '1') {
                    dfs(i,j);
                    res ++ ;
                }
            }
        }
        return res;
    }

    private void dfs(int x, int y){
        for (int i = 0; i < 4; i++) {
            int newX = x + M[i];
            int newY = x + N[i];
            if (outArea(newX,newY)) {
                continue;
            } else if (ori[newX][newY] == '0') {
                ori[newX][newY] = '2';
                continue;
            } else if (ori[newX][newY] == '1'){
                ori[x][y] = '2';
                dfs(newX,newY);
                continue;
            }
        }
    }

    private boolean outArea(int x, int y) {
        if (x < 0 || y < 0 || x >= X || y >= Y || ori[x][y] == '2') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        q200 q200 = new q200();
        q200.numIslands(new char[][] {
                {'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}
        });
    }
}
