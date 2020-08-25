/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

import java.util.Arrays;

/**
 * @author huangzuo
 * @version : q42.java, v 0.1 2020年08月24日 8:19 上午 huangzuo Exp $
 */
public class q42 {
    public int trap(int[] height) {
        if (height.length <= 3) {
            return 0;
        }
        //找到数组最大值
        int max = Arrays.stream(height).max().getAsInt();
        boolean isMax = false;
        int curr = 0;
        int res = 0;
        for (int index : height) {
            if (!isMax && index > curr) {
                curr = index;
            }
            if (curr > 0) {
                res += curr - index;
            }
            if (isMax && index < curr) {
                curr = index;
            }
            if (index == max) {
                isMax = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        final q42 q42 = new q42();
        System.out.println(q42.trap(new int[]{
                0,2,0}));
    }
}
