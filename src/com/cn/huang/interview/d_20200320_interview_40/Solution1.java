/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.interview.d_20200320_interview_40;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * 堆排序
 *
 *
 * @author huangzuo
 * @version : Solution1.java, v 0.1 2020年03月20日 10:58 上午 huangzuo Exp $
 */
public class Solution1 {
    public static int[] getLeastNumbers(int[] arr, int k) {

        if (k == 0) {
            return new int[0];
        }

        //输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
        Queue<Integer> heap = new PriorityQueue<>(k,(i,j) -> Integer.compare(j,i));

        for (int e : arr){
            //heap 为空 或者 heap 或者
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()){
                heap.add(e);
            }

            if (heap.size() > k){
                heap.poll();
            }
        }

        int count = 0;
        int[] res = new int[heap.size()];
        for (int e : heap){
            res[count++] = e;
        }

        return res;
    }

    public static void main(String[] args) {
        getLeastNumbers(new int[]{0,1,2,1,4,5,63,4},5);
    }
}
