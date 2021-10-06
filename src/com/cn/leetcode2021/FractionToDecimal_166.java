package com.cn.leetcode2021;

import java.util.HashMap;

/**
 * @author HUANG Zuo
 * @version create_time：2021-10-03 22:19:59
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class FractionToDecimal_166 {

    public String fractionToDecimal(int numerator, int denominator) {
        long nu = numerator;
        long de = denominator;
        if (nu % de == 0) {
            return nu/de + "";
        }
        StringBuilder sb = new StringBuilder();
        if (nu * de < 0) {
            sb.append("-");
        }
        nu = Math.abs(nu);
        de = Math.abs(de);
        sb.append(nu / de).append(".");
        nu %= de;
        HashMap<Long, Integer> index = new HashMap<>();
        while (nu != 0) {
            index.put(nu, sb.length());
            nu *= 10;
            sb.append(nu / de);
            nu %= de;
            if (index.containsKey(nu)) {
                int currSb = index.get(nu);
                return String.format("%s(%s)", sb.substring(0, currSb), sb.substring(currSb));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FractionToDecimal_166 fractionToDecimal_166 = new FractionToDecimal_166();
        System.out.println(fractionToDecimal_166.fractionToDecimal(50, 7));
    }
}
