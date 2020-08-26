/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

/**
 * @author huangzuo
 * @version : q7.java, v 0.1 2020年08月25日 8:56 下午 huangzuo Exp $
 */
public class q7 {

    public int reverse(int x) {
        int ans = 0;

        while (x != 0) {
            int pop = ans % 10;
            //当ans>max/10时，必溢出；当ans==max/10且pop>7，必溢出
            if ((ans > Integer.MAX_VALUE / 10) || ((ans == Integer.MAX_VALUE / 10) && (pop > 7))) {
                return 0;
            }
            //当ans<min/10时，必溢出；当ans==min/10且pop<-8，必溢出
            if ((ans < Integer.MIN_VALUE / 10) || ((ans == Integer.MIN_VALUE / 10) && (pop < -8))) {
                return 0;
            }
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
}
