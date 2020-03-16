/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package d_20200312_question1071;

/**
 * @author huangzuo
 * @version : Solution1.java, v 0.1 2020年03月12日 4:15 下午 huangzuo Exp $
 */
public class Solution1 {
    //辗转相除法，两个正整数a和b（a>b），它们的最大公约数等于a除以b的余数c和b之间的最大公约数
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

    public static String gcdOfStrings(String str1,String str2){
        if (!(str1 + str2).equals((str2 + str1))) {
            return "";
        }else {
            return str1.substring(0,gcd(str1.length(),str2.length()));
        }
    }
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABAB","ABAB"));
    }
}
