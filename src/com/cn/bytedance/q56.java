/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author huangzuo
 * @version : q56.java, v 0.1 2020年08月24日 11:31 下午 huangzuo Exp $
 */
public class q56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] currIntervals = intervals[i];
            int[] lastIntervals = res.get(res.size() - 1);

            if (currIntervals[0] > lastIntervals[1]){
                res.add(currIntervals);
            } else {
                lastIntervals[1] = Math.max(lastIntervals[1],currIntervals[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
