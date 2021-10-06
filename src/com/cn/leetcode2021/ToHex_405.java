package com.cn.leetcode2021;

/**
 * @author HUANG Zuo
 * @version create_time：2021-10-02 20:16:44
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class ToHex_405 {
    public String toHex(int num) {
        if (num == 0) return "0";

        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int curr = num & 15;
            if (curr >= 10) {
                sb.append((char) (curr - 10 + 'a'));
            } else sb.append(curr);

            num >>>= 4;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ToHex_405 toHex_405 = new ToHex_405();
        toHex_405.toHex(26);
    }
}
