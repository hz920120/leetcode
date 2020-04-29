/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author huangzuo
 * @version : MoveZeroes.java, v 0.1 2020年04月28日 11:10 下午 huangzuo Exp $
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        //找到所有0的索引，0~1之间不用动，第n~n+1个0中间的数向左移动n，后面向左移动n+1位
        int len = nums.length;
        if (len == 0){return;}
        int n = -1;
        int n1 = -1;
        //计算0的数量
        int countZero=0;

        for (int i = 0; i < len ; i++) {
            //找寻左0索引
            if (nums[i]==0 && n == -1){
                n = i;
                countZero++;
            }
            //找寻右0索引
            else if (nums[i]==0 && n!=-1){
                n1 = i;
                countZero++;
            }
            //左右0都找到，移动索引区间内的数字
            if (n!=-1 && n1!=-1) {
                move(nums,n,n1,countZero-1);
                //移动完右赋值给左，右重置为-1，继续下次寻找
                n = n1;
                n1=-1;
            }
            //找到最后一个数时，最后一个移动区间集体左移，这时假设数组最右端外边还有个0，所以steps没有-1
            if (i == len-1){
                move(nums,n,len,countZero);
            }
        }
        //把数组右边countZero个数都置为0
        for (int i = len-1; i > len-1-countZero ; i--) {
            nums[i] = 0;
        }
    }

    /**
     * @param nums 数组
     * @param n 区间左端点
     * @param n1 区间右端点
     * @param steps 左移步数
     */
    private void move(int[] nums,int n,int n1,int steps){
        //移动步数是steps
        for (int i = n+1; i < n1; i++) {
            nums[i-steps] = nums[i];
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] ints = new int[]{0,1,0,3,12,0,4,5,6,0,7,8};
        moveZeroes.moveZeroes(ints);
        System.out.println(1);
    }
}
