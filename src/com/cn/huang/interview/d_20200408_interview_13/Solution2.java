/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.interview.d_20200408_interview_13;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * @author huangzuo
 * @version : Solution2.java, v 0.1 2020年04月09日 11:03 下午 huangzuo Exp $
 */
public class Solution2 {

//    private int res = 0;
//    private int m;
//    private int n;
//    private int k;
//    boolean[][] visited;
//
//    public int movingCount(int m, int n, int k) {
//        this.m = m;
//        this.n = n;
//        this.k = k;
//        this.visited = new boolean[m][n];
//        return dfs(0,0,0,0);
//
//    }
//
//    private int dfs(int x,int y,int sx,int sy){
//        if (x > m-1 || y > n -1 || sx + sy > k || visited[x][y]){return 0;}
//        visited[x][y] = true;
//        res++;
//        dfs(x+1,y,x+1 % 10 == 0 ? sx-8:sx+1,sy);
//        dfs(x,y+1,sx,y+1 % 10 == 0 ? sy-8:sy+1);
//        return res;
//    }

    private int m;
    private int n;
    private int k;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0,0,0,0);

    }

    private int dfs(int x,int y,int sx,int sy){
        if (x > m-1 || y > n -1 || sx + sy > k || visited[x][y]){return 0;}
        visited[x][y] = true;
        return 1+dfs(x+1,y,(x+1) % 10 == 0 ? sx-8:sx+1,sy)+dfs(x,y+1,sx,(y+1) % 10 == 0 ? sy-8:sy+1);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.movingCount(11,8,16));
    }

}
