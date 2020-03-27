/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.march.d_20200327_question_914;

/**
 * @author huangzuo
 * @version : Solution1.java, v 0.1 2020年03月27日 4:09 下午 huangzuo Exp $
 */
public class Solution1 {

    public boolean hasGroupsSizeX(int[] deck) {

        if (deck.length <= 1){
            return false;
        }

        int[] count = new int[10000];

        for (int ele : deck){
            count[ele] ++;
        }

        int g = -1;

        for (int i = 0; i < count.length ; i++) {
            if (count[i] > 0){
                if (g == -1){
                    g = count[i];
                }else {
                    g = gcd(g,count[i]);
                }
            }
        }
        return g>=2;

    }

    public int gcd(int x, int y) {
        return x % y == 0 ? y : gcd(y,x%y);
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
//        System.out.println(solution1.gcd(100,80));
        System.out.println(solution1.hasGroupsSizeX(new int[]{0,0,1,1,1,1,2,2,3,4}));

    }
}
