package com.cn.leetcode2022;

import java.util.Random;

/**
 * @author HUANG Zuo
 * @version create_time：2022-01-05 15:39:06
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class ModifyString_1576 {

    char[] letters = new char[]{'a', 'b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
            'q','r','s','t','u','v','w','x','y','z'};

    public String modifyString(String s) {
        String res = "";
        if (s == null || s.length() == 0) {
            return res;
        }
        
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] - 'a' < 0) {
                int left = i > 0 ? chars[i-1] - 'a' : -1;
                int right = i == s.length() - 1 ? -1 : chars[i+1] - 'a';
                chars[i] = letters[getRanIndex(0, 25, left, right)];
            }
        }

        return new String(chars);
    }

    private int getRanIndex(int start, int end, int not1, int not2) {
        Random r = new Random();
        int res = r.nextInt(end - start) + start;
        while (res == not1 || res == not2) {
            res = r.nextInt(end - start) + start;
        }
        return res;
    }

    public static void main(String[] args) {
//        int random = (int) (Math.random() * 25 + 1);
        ModifyString_1576 modifyString_1576 = new ModifyString_1576();
        System.out.println(modifyString_1576.modifyString("j?qg??b"));

    }
}
