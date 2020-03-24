/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.interview.problem.march.d_20200320_question_1217;

import java.util.*;

/**
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月20日 3:32 下午 huangzuo Exp $
 */
public class Solution {
    public static int minCostToMoveChips(int[] chips) {

        int length = chips.length;

        if (length == 1) {
            return 0;
        }

        if (length == 2) {
            return (chips[1] - chips[0]) % 2 == 0 ? 0 : 1;
        }

        //先对chips排序
        Arrays.sort(chips);
        //放进桶里
//        int[] bucks = new int[chips[length-1] + 1];

        Map<Integer,Integer> bucks = new HashMap<>();
        int min = chips[0];
        int max = chips[0];
        for (int i : chips) {
            if (bucks.get(i) == null){
                bucks.put(i,1);
            }else {
                bucks.put(i,bucks.get(i) + 1);
            }
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        double half = Double.valueOf(max + min)/2;

        if (half > min && half< max){
                return Math.min(leftDis(bucks,(int)half)+rightDis(bucks,(int)half),
                        leftDis(bucks,(int)half+1)+rightDis(bucks,(int)half+1));
        }else {
            return Math.min(leftDis(bucks,max),rightDis(bucks,min));
        }

    }

    private static int rightDis(Map<Integer,Integer> bucks,int index){
        int res = 0;
        a : for (Map.Entry<Integer,Integer> chipAmout : bucks.entrySet()){
            if (chipAmout.getKey() < index) continue a;
            if (chipAmout.getKey() > index && ((chipAmout.getKey() - index)) % 2 != 0) res+= chipAmout.getValue();
        }
        return res;
    }

    private static int leftDis(Map<Integer,Integer> bucks,int index){
        int res = 0;
        a : for (Map.Entry<Integer,Integer> chipAmout : bucks.entrySet()){
            if (chipAmout.getKey() > index) continue a;
            if (chipAmout.getKey() < index && ((chipAmout.getKey() - index)) % 2 != 0) res+= chipAmout.getValue();
        }
        return res;
    }



//    public int minCostToMoveChips1(int[] chips) {
//
//        int length = chips.length;
//        double half = Double.valueOf(length)/2;
//        if (length == 1) {
//            return 0;
//        }
//
//        if (length == 2) {
//            return (chips[1] - chips[0]) % 2 == 0 ? 0 : 1;
//        }
//
//        //先对chips排序
//        Arrays.sort(chips);
//        //放进桶里
//        int[] bucks = new int[chips[length-1] + 1];
//        int min = chips[0];
//        int max = chips[0];
//        for (int i : chips) {
//            bucks[i] += 1;
//            if (i > max) {
//                max = i;
//            }
//            if (i < min) {
//                min = i;
//            }
//        }
//        if (half > min && half< max){
//            return Math.min(leftDis(bucks,(int)half,min)+rightDis(bucks,(int)half,max),
//                    leftDis(bucks,(int)half+1,min)+rightDis(bucks,(int)half+1,max));
//        }else {
//            return Math.min(leftDis(bucks,max,0),rightDis(bucks,0,max));
//        }
//
//    }
//
//    private int rightDis(int[] bucks,int index,int max){
//        int res = 0;
//        for (int i = index +1; i <= max; i++) {
//            if ((i - index) % 2 != 0 ){
//                res += bucks[i];
//            }
//        }
//        return res;
//    }
//
//    private int leftDis(int[] bucks,int index,int min){
//        int res = 0;
//        for (int i = index - 1; i >= min; i--) {
//            if ((i - index) % 2 != 0 ){
//                res += bucks[i];
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        System.out.println(minCostToMoveChips(new int[]{591413175,182351872,756860273,696092252,20210353,323162074,476584498,306095182,660417876,728812299,191787370,103693457,133652629,507004362,782205709,848935607,277975501,587105726,12363201,464649772,945173326,348878230,721952308,622248693,725560506,619321800,565827834,624429737,815643221,465829523,492902445,449434481,475131519,548957626,563881909,995458745,875600259,560225012,335452122,691650711,92112576,666156311,106763524,798718513,474522008,689388489,14339396,549911467,373072280,181683654,688688869,175196193,611188861,774186218,926814023,244034213,789884175,272918989,897017832,936636802,257803798,106694220,747411765,475950002,740218617,28836055,176693592,104527871,713943436,275808930,526812619,484377045,196631523,678048699,132493640,194983387,735090022}));
    }
}
