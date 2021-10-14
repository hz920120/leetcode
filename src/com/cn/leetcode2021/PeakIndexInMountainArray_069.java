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

        int left = arr.length >> 1;
        int right = arr.length >> 1;
        int maxIndex = left;
        while (left >= 1 || right <= arr.length - 2) {
            if (right + 1 >= arr.length) {
                maxIndex = arr[--left] > arr[maxIndex] ? left : maxIndex;
            } else {
                maxIndex = arr[--left] > arr[++right] ? (arr[left] > arr[maxIndex] ? left : maxIndex) :
                        (arr[right] > arr[maxIndex] ? right : maxIndex);
            }
        }

        return maxIndex;
    }

}
