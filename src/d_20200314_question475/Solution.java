/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package d_20200314_question475;

import sun.tools.attach.HotSpotVirtualMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
 *
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.
 *
 * So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.
 *
 * Note:
 *
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 *
 *
 * Example 1:
 *
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 *
 *
 * Example 2:
 *
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 *
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月14日 10:07 下午 huangzuo Exp $
 */
public class Solution {
    //1.有1个暖气，离两个端点的最大值为半径
    //2.有2个暖气，


    //[1,2,3,4,5,6,7,8,9,10],[4,9]

    //方法1 取分割区间的最大值

    public static int findRadius(int[] houses, int[] heaters) {
//        Arrays.sort(houses);
//        Arrays.sort(heaters);
        if (heaters.length == 1){
            // [1,2,3],[1]
            return heaters[0] - houses[0] > houses[houses.length - 1] - heaters[0] ? heaters[0] - houses[0] : houses[houses.length - 1] - heaters[0];
        }
        List<Integer> heaterList = arrayToList(heaters);
        boolean bool = true;
        if (heaters.length >= houses.length){
            for (int house : houses){
                bool = heaterList.contains(house) & bool;
            }
        }

        if (bool){
            return 0;
        }else {
            int minDis = houses.length - 1;
            int leftPoint = houses[0];
            int rightPoint = houses[houses.length - 1];
            for (int i = 0; i < heaters.length; i++) {
                int dis = heaters[i] - leftPoint > rightPoint - heaters[i] ? heaters[i] - leftPoint : rightPoint - heaters[i];
                if (dis <= minDis) {
                    minDis = dis;
                }
                if (heaters[i] > leftPoint) {
                    leftPoint = heaters[i];
                }
                if (heaters[i] > rightPoint / 2 && heaters[i] < rightPoint) {
                    rightPoint = heaters[i];
                }
            }

            return minDis / 2 < 1 ? 1 : minDis / 2;
        }
    }

    public static List<Integer> arrayToList(int[] buf){
        List<Integer> list = new ArrayList<>();
        for(int i : buf){
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findRadius(new int[]{1,2,5},new int[]{1,2,5}));
//        System.out.println( Arrays.asList(new int[]{1,2,3}));
//        System.out.println(arrayToList(new int[]{1,2,3}).contains(1));

    }
}
