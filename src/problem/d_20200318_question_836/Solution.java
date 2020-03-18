/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package problem.d_20200318_question_836;

/**
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner, and (x2, y2) are the coordinates of its top-right corner.
 *
 * Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch at the corner or edges do not overlap.
 *
 * Given two (axis-aligned) rectangles, return whether they overlap.
 *
 * Example 1:
 *
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 * Example 2:
 *
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output: false
 * Notes:
 *
 * Both rectangles rec1 and rec2 are lists of 4 integers.
 * All coordinates in rectangles will be between -10^9 and 10^9.
 *
 *
 * @author huangzuo
 * @version \: Solution.java, v 0.1 2020年03月18日 11:19 上午 huangzuo Exp $
 */
public class Solution {
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //rec[2]-rec[0]为投影到x轴边长，rec[3]-rec[1]为投影到y轴边长
//        //保证rec2的面积始终比rec1小
//        if ((rec1[2] - rec1[0])*(rec1[3]-rec1[1]) < (rec2[2] - rec2[0]) * (rec2[3]-rec2[1])){
//            return isRectangleOverlap(rec2,rec1);
//        }
        if (rec2[3] < rec1[1] || rec2[2] < rec1[0]){
            return false;
        }
        //rec2的任意端点在rec1的内

        boolean b = false;
        if (isInnerPoint(rec2[0],rec2[1],rec1) ||
            isInnerPoint(rec2[2],rec2[1],rec1) ||
            isInnerPoint(rec2[2],rec2[3],rec1) ||
            isInnerPoint(rec2[0],rec2[3],rec1)
        ){
            b = true;
        }


        return false;
    }

    private static boolean isInnerPoint(int x, int y, int[] rec){
        if (rec[0]<x && x <rec[2]){
            if (rec[1]<= y && y <= rec[3]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
        //[7,8,13,15]
        //[10,8,12,20]
        System.out.println(isRectangleOverlap(new int[]{0,0,1,1},new int[]{1,0,2,1}));
    }
}
