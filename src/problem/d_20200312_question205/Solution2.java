/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package problem.d_20200312_question205;

import java.util.HashMap;

/**
 * Two strings are isomorphic if the positions of the characters follow the same pattern. So I'm using maps to compare the position patterns.
 *
 * For example:
 *
 * String 1:              A B E A C D B
 * index pattern:         0 1 2 0 4 5 1
 * String 2:              X Y I X H K Y
 * index pattern:         0 1 2 0 4 5 1
 *
 * @author huangzuo
 * @version : Solution2.java, v 0.1 2020年03月13日 11:53 下午 huangzuo Exp $
 */
public class Solution2 {

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        if (s.length() == 1){
            return true;
        }

        HashMap<Character, Integer> mapS = new HashMap<>();
        String strS = "";
        HashMap<Character, Integer> mapT = new HashMap<>();
        String strT = "";

        for (int i=0; i < s.length(); i++){
            if (mapS.get(s.charAt(i)) == null){
                strS += String.valueOf(i);
                mapS.put(s.charAt(i),i);
            }else {
                strS += mapS.get(s.charAt(i));
            }
            if (mapT.get(t.charAt(i)) == null){
                strT += String.valueOf(i);
                mapT.put(t.charAt(i),i);
            }else {
                strT += mapT.get(t.charAt(i));
            }
        }

        if (strS.equals(strT)){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("ABEACDB","XYIXHKY"));
    }
}
