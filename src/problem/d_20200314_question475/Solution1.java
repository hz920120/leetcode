/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package problem.d_20200314_question475;

/**
 * 1.对于每个房屋，要么用前面的暖气，要么用后面的，二者取近的，得到距离；
 * 2.对于所有的房屋，选择最大的上述距离。
 *
 * @author huangzuo
 * @version : Solution1.java, v 0.1 2020年03月16日 4:34 下午 huangzuo Exp $
 */
public class Solution1 {

    public static int findRadius(int[] houses, int[] heaters) {
        //1.对于每个房屋，要么用前面的暖气，要么用后面的，二者取近的，得到距离；
        //[1,2,3,4],[1,4]
        int maxR = 0;
        for (int i=0;i<houses.length;i++){
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;
            //每个房屋最近的取暖器距离
            int minR = Integer.MAX_VALUE;
            for (int j=0;j<heaters.length;j++){

                if (heaters[j] == houses[i]){
                    minR = 0;
                    break;
                }
                //寻找前边的暖气
                if (heaters[j] < houses[i]){
                    //取较小的暖气距离为左边半径left
                    left = houses[i] - heaters[j] < left ? houses[i] - heaters[j] : left;
                }
                //寻找后边的暖气
                if (heaters[j] > houses[i]){
                    //取较小的暖气距离右边半right
                    right = heaters[j] - houses[i] < right ? heaters[j] - houses[i] : right;
                }
            }
            minR = (minR == 0 ? 0:Math.min(left,right));
            maxR = Math.max(maxR,minR);
        }

        return maxR;
    }

    public static void main(String[] args) {
        System.out.println(findRadius(new int[]{1},new int[]{1,2}));
    }
}
