/*
 * Miya.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.cn.huang.problem.year2021.march;

/**
 * @author huangzuo
 * @version : d_20210301_303.java, v 0.1 2021年03月01日 10:52 下午 huangzuo Exp $
 */
public class d_20210301_303 {

    int[] presums;

    public d_20210301_303(int[] nums) {
        //prenums 大小是 nums+1
        presums = new int[nums.length + 1];

        // prenums[n] = prenums[n-1] + nums[n]
        for (int i = 1; i <= nums.length; i++) {
            presums[i] = presums[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return presums[j+1] - presums[i];
    }
}
