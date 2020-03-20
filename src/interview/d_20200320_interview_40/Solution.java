/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package interview.d_20200320_interview_40;

import java.util.Arrays;

/**
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月20日 10:05 上午 huangzuo Exp $
 */
public class Solution {
    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        if (k == 0 ){
            return res;
        }else {
            System.arraycopy(arr, 0, res, 0, k);
        }
        return res;
    }

    public static void main(String[] args) {
        getLeastNumbers(new int[]{0,1,2,1},0);
    }
}
