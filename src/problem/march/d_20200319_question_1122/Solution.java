/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package problem.march.d_20200319_question_1122;

import com.sun.javafx.collections.MappingChange;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 *
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * Constraints:
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * Each arr2[i] is distinct.
 * Each arr2[i] is in arr1.
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月19日 9:45 下午 huangzuo Exp $
 */
public class Solution {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        //遍历arr1，算出各个数字的个数

        Arrays.sort(arr1);
        Map<Integer,Integer> arr1Map = new HashMap<>();
        for (int i = 0;i < arr1.length; i++){
            if (arr1Map.get(arr1[i]) == null){
                arr1Map.put(arr1[i],1);
            }else {
                arr1Map.put(arr1[i],arr1Map.get(arr1[i]) + 1);
            }
        }

//        System.arraycopy();
        int size = arr1.length;
        int[] out1 = new int[arr1.length];

        int count1 = 0 ;

        for (int i : arr2){
            if (arr1Map.get(i) == 1){
                out1[count1] = i;
                count1++;
                size--;
            }else {
                for (int j = 0; j< arr1Map.get(i);j++){
                    out1[count1] = i;
                    count1++;
                    size--;
                }
            }

            arr1Map.remove(i);
        }

        if (arr1Map.size() == 0){
            return out1;
        }

        int[] out2 = new int[size];
        int count2 = 0 ;
        for (int m : arr1Map.keySet()){
            if (arr1Map.get(m) == 1){
                out2[count2] = m;
                count2++;
            }else {
                for (int j = 0; j < arr1Map.get(m); j++) {
                    out2[count2] = m;
                    count2++;
                }
            }
        }
        Arrays.sort(out2);

        System.arraycopy(out2,0,out1,out1.length-size,size);
        return out1;
    }

    public static void main(String[] args) {
        // * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
        // * Output: [2,2,2,1,4,3,3,9,6,7,19]
        //[2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31]
        //[2,42,38,0,43,21]

//[2,3,1,3,2,4,6,7,9,2,19]
//[2,1,4,3,9,6]
        for (int i: relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19,19},new int[]{2,1,4,3,9,6})){
            System.out.print(i);
        }
//        int[] out1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
//        int[] out2 = new int[]{2,1,4,3,9,6};

//        System.arraycopy(out2,0,out1,out1.length-out2.length,out2.length);
//        System.out.println(1);
    }
}
