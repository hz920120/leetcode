package com.cn.leetcode2021;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-23 10:41:24
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        return process(n);
    }

    public boolean process(double n) {
        if (n == 1) return true;
        if (n < 1) return false;
        return process(n / 3L);
    }

    public static void main(String[] args) {
        IsPowerOfThree isPowerOfThree = new IsPowerOfThree();
        System.out.println(isPowerOfThree.isPowerOfThree(45));
    }
}
