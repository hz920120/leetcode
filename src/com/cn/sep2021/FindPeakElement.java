package com.cn.sep2021;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-15 17:05:47
 * @declaration 162
 * @e-mail hz920120@gmail.com
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] <= max) {
                i++;
                continue;
            }
            max = nums[i];
            if (i + 1 >= nums.length) {
                return i;
            }

            if (nums[i] > nums[i+1]) {
                return i;
            }
            i++;
        }

        return -1;
    }


    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        findPeakElement.findPeakElement(new int[]{1,2});
        System.out.println(1);
    }
}
