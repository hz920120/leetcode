/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package problem.march.d_20200312_question_1071;

/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 示例 1：
 *
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 *
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 *
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月12日 2:13 下午 huangzuo Exp $
 */
public class Solution {
    public static String gcdOfStrings(String str1, String str2) {
        String[] strings1 = str1.split("");
        String[] strings2 = str2.split("");
        int len = gcd(str1.length(),str2.length());
        //保证strings1的长度大
        if (strings1.length < strings2.length){
            String[] temp;
            temp = strings1;
            strings1 = strings2;
            strings2 = temp;
        }

        String max = "";
        for (int i = 0;i < strings1.length; i++){
            for (int j = 0; j < strings2.length; j++){
                if (strings1[i].equals(strings2[j])){
                    String str = "";
                    for (int m = 0; m < strings2.length - j;m ++){
                        if (strings1[i+m].equals(strings2[j+m])){
                            str += strings1[i+m];
                        }
                    }
                    if (str.length() > max.length()){
                            max = str;

                    }
                    if (str.length() == str2.length()){
                        return max.substring(0,len);
                    }
                }

            }
        }

        return max.substring(0,len);
    }

    public static int gcd(int a,int b){
        if (a < b){
            return gcd(b,a);
        }
        if (a % b ==0){
            return b;
        }
        else {
            return gcd(b,a%b);
        }
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("LEET","CODE"));
    }
}
