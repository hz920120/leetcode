/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.interview.d_20200408_interview_13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huangzuo
 * @version : Solution1.java, v 0.1 2020年04月08日 9:12 下午 huangzuo Exp $
 */
public class Solution1 {


    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        //index 0和1代表方格索引，index 2和3代表横坐标和纵坐标的位数和
        queue.add(new int[]{0,0,0,0});
        int res = 0;
        while (queue.size() > 0){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int sx = cur[2];
            int sy = cur[3];
            if (x >= m || y >= n || sx + sy > k || visited[x][y]) {continue;}
            res++;
            visited[x][y] = true;
            queue.add(new int[]{x+1,y,(x+1) % 10 == 0 ? sx - 8 : sx + 1,sy});
            queue.add(new int[]{x,y+1,sx,(y+1) % 10 == 0 ? sy - 8 : sy + 1});
        }
        return res;
    }

}
