/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package problem.march.d_20200321_question_365;

/**
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月21日 10:59 上午 huangzuo Exp $
 */
public class Solution {

    private static int big;
    private static int small;
    private static int target;


    public static boolean canMeasureWater(int x, int y, int z) {

        if (x == 0 && y == 0){
            return z == 0;
        }
        if (x > y) {
            return canMeasureWater(y,x,z);
        }
//        if (z > y){
//            return canMeasureWater(x,z,y);
//        }
        if (x == 0 || y ==0){
            return x == z || y == z;
        }
        big = y;
        small = x;
        target = z;
        if (z == x || z == y || z == y - x){
            return true;
        }
        return getDiff(x,y);

    }

    public static boolean getDiff(int x,int y){
        if (x > y) {
            return getDiff(y,x);
        }
        int diff = y-x;
        if (diff == 0 || diff == 1){
            return big-diff == target || small - diff == target;
        }else {
            if (big - diff == target || small - diff == target){
                return true;
            }else {
                return getDiff(diff, x);
            }
        }
    }

    public static void main(String[] args) {
        //x = 3, y = 5, z = 4
        System.out.println(canMeasureWater(4,6,8));
    }
}
