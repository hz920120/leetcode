package com.cn.leetcode2021;

/**
 * @author HUANG Zuo
 * @version create_time：2021-10-14 22:19:12
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class PeakIndexInMountainArray_069 {

    public int peakIndexInMountainArray(int[] arr) {
        if (arr.length == 3) {
            return Math.max(arr[0], Math.max(arr[1], arr[2]));
        }

        int left = 0;
        int right =  arr.length - 1;
        while (left <= right) {
            if (arr[left] > arr[++left]) {
                return left - 1;
            }
            if (arr[right] > arr[--right]) {
                return right  + 1;
            }
        }
        return left;
    }

}
