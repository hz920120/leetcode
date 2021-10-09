package com.cn.leetcode2021;

/**
 * @author HUANG Zuo
 * @version create_time：2021-10-07 10:08:58
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class CountSegments_434 {


    public int countSegments(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; ) {
            if (s.charAt(i) == ' ' && i++ >= 0) continue;
            while (i < n && s.charAt(i) != ' ') i++;
            ans++;
        }
        return ans;
    }



    public static void main(String[] args) {
        CountSegments_434 countSegments_434 = new CountSegments_434();
        countSegments_434.countSegments(", , , ,        a, eaefa");
    }

}
