package com.cn.leetcode2021;

/**
 * @author HUANG Zuo
 * @version create_time：2021-10-11 21:56:30
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class NumberToWords_273 {

    static String[] low = new String[] {"Zero",
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] mid = new String[] {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] high = new String[] {"Billion", "Million", "Thousand", ""};


    public String numberToWords(int num) {
        if (num == 0) return low[num];

        StringBuilder sb = new StringBuilder();
        for (int i = 1000000000, j = 0; i >=1 ; i /= 1000, j++) {
            if (num < i) continue;
            sb.append(num2Str(num / i) + high[j] + " ");
            num %= i;
        }
        while (sb.charAt(sb.length() - 1) == ' ') sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String num2Str (int x) {
        String res = "";
        if (x >= 100) {
            res += low[x / 100] + " Hundred ";
            x %= 100;
        }
        if (x >= 20) {
            res += mid[x / 10] + " ";
            x %= 10;
        }
        if (x != 0) {
            res += low[x] + " ";
        }
        return res;
    }

    public static void main(String[] args) {
        NumberToWords_273 numberToWords_273 = new NumberToWords_273();
        System.out.println(numberToWords_273.numberToWords(1234314231));
    }

}
