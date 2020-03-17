/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package interview.d_20200316_interview_01_06;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 *
 * 提示：字符串长度在[0, 50000]范围内。
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月16日 5:25 下午 huangzuo Exp $
 */
public class Solution {
    public static String compressString(String S) {

        if (S!= null && S.length() <= 2){
            return S;
        }

        //循环S，出现第一个与循环的数组不同的字符，则重新复制字符，重新计数
        char[] SChar = S.toCharArray();
        char currentChar = SChar[0];
        int count = 1;

        StringBuilder out = new StringBuilder();
        for (int i = 1 ; i< SChar.length ; i++){
            if ( SChar[i] == currentChar){
                count++;
            }else {
                out.append(SChar[i-1]).append(count);
                currentChar = SChar[i];
                count = 1;
            }
            if (i== SChar.length-1){
                out.append(SChar[i]).append(count);
            }
        }
        System.out.println(out);

        return out.length()<S.length()?out.toString():S;
    }


    //心得：使用StringBuilder效率比字符串拼接字符串效率高很多

    public static void main(String[] args) {
        System.out.println(compressString("IIIIeeeeOODDDssppppooQQQQppplllhU"));

//        char a = 'a';
//        char b = 'a';
//        System.out.println(a==b);
//        "I4e4O2D3s2p4o2Q4p3l3h1U1"
//        "I4e4O2D3s2p4o2Q4p3l3h1h1"
    }
}
