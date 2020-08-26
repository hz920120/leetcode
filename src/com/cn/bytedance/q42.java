/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

/**
 * @author huangzuo
 * @version : q42.java, v 0.1 2020年08月24日 8:19 上午 huangzuo Exp $
 */
public class q42 {
    public int trap(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int res = 0;

        //最大值与最大值位置（找到一个最大值即可）
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }

        //左边
        int current = height[0];
        for (int i = 1; i < maxIndex; i++) {
            if (height[i] < current) {
                res += (current - height[i]);
            } else {
                current = height[i];
            }
        }

        //右边
        current = height[height.length-1];
        for (int i = height.length - 2;  i >= maxIndex ; i--) {
            if (current > height[i]) {
                res += (current - height[i]);
            } else {
                current = height[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        final q42 q42 = new q42();
        System.out.println(q42.trap(new int[]{
                2,0,2}));
    }
}
