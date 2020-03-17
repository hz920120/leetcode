package problem.d_20200311_question1013;/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */

/**
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 *
 * 示例 1：
 *
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 *
 * 示例 2：
 *
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 *
 * @author huangzuo
 * @version : ques.Solution.java, v 0.1 2020年03月11日 11:56 下午 huangzuo Exp $
 */
public class Solution {
    public static boolean canThreePartsEqualSum(int[] A) {
        int length = A.length;
        if (length < 3 || length > Integer.MAX_VALUE){
            return false;
        }
        //数组和一定是3的整数倍
        int arrSum = 0;
        for (int a : A){
            arrSum += a;
        }
        if (arrSum % 3 != 0){
            return false;
        }
        //从头开始加，加到arrSum/3为一段
        int target = arrSum/3;
        int fst = 0;
        int sepPoint1 =0;
        int sepPoint2 =0;

        for (int i = 0 ; i< length;i++){
            fst += A[i];
            if (i>length-3){
                return false;
            }
            if (fst == target && i <length) {
                sepPoint1 = i;
                break;
            }
        }

        for (int i = sepPoint1+1;i< length;i++){
            fst += A[i];
            if (i>length-2){
                return false;
            }
            if (fst == 2*target && i <length) {
                sepPoint2 = i;
                break;
            }
        }

        System.out.println("结果为 : " + true);

        for (int i = 0 ; i< length;i++){
            System.out.print(A[i]);
            if (i<sepPoint1){
                System.out.print(" + ");
            }
            if (i == sepPoint1){
                System.out.print(" = ");
            }
            if (i>sepPoint1 && i<sepPoint2){
                System.out.print(" + ");
            }
            if (i == sepPoint2){
                System.out.print(" = ");
            }
            if (i > sepPoint2 && i < length -1){
                System.out.print(" + ");
            }

        }

        return true;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,-1,1,-1};
        System.out.println(canThreePartsEqualSum(ints));
    }
}
