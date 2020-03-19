/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package problem.d_20200319_question_409;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzuo
 * @version : Solution1.java, v 0.1 2020年03月19日 3:53 下午 huangzuo Exp $
 */
public class Solution1 {
    public static int longestPalindrome(String s) {

        if (s !=null && s.trim().length() == 1){
            return 1;
        }

        int[] charInt = new int[60];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length ; i++){
            charInt[chars[i] - 'A'] += 1;
        }

        int length = 0;
        boolean hasMiddle = true;
        a : for (int i = 0; i < 60; i++){
            if (charInt[i] == 0 ){
                continue a;
            }
            if (charInt[i] % 2 == 0){
                length += charInt[i];
            }
            if (charInt[i] % 2 == 1){
                if (hasMiddle == true) {
                    length += charInt[i];
                    hasMiddle = false;
                }else {
                    length += (charInt[i] - 1);
                }

            }
        }


        return length;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
//        System.out.println('z'-'A');
    }
}
