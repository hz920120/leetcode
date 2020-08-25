/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

/**
 * @author huangzuo
 * @version : q11.java, v 0.1 2020年08月24日 10:07 下午 huangzuo Exp $
 */
public class q11 {

    public int maxArea(int[] height) {
        //移动短板不会导致最大面积的丢失
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            max = height[i] < height[j] ?
                    Math.max(max, (j - i) * height[i] ) :
                    Math.max(max, (j - i) * height[j] );
        }
        return max;

    }


}
