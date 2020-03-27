/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.march.d_20200327_question_914;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In a deck of cards, each card has an integer written on it.
 *
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 *
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 *  
 *
 * Example 1:
 *
 * Input: deck = [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
 * Example 2:
 *
 * Input: deck = [1,1,1,2,2,2,3,3]
 * Output: false´
 * Explanation: No possible partition.
 * Example 3:
 *
 * Input: deck = [1]
 * Output: false
 * Explanation: No possible partition.
 * Example 4:
 *
 * Input: deck = [1,1]
 * Output: true
 * Explanation: Possible partition [1,1].
 * Example 5:
 *
 * Input: deck = [1,1,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[2,2].
 *  
 *
 * Constraints:
 *
 * 1 <= deck.length <= 10^4
 * 0 <= deck[i] < 10^4
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月27日 10:52 上午 huangzuo Exp $
 */
public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length <= 1){
            return false;
        }
        Arrays.sort(deck);
        //第一个元素
        int first = deck[0];
        //初始化最小数的个数
        int x = 1 ;
        //找到最小数的个数x
        for (int i = 1; i < deck.length; i++) {
            if (deck[i] != first){
                if (i == 1){
                    return false;
                }else {
                    x=i;
                    break;
                }
            }else x++;
        }

        return isGroup(num(x),deck);

    }

    //找到num的非1因数并保存
    public List<Integer> num(int num){
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= num ; i++) {
            if (num % i == 0){
                res.add(i);
            }
        }
        return res;
    }

    //数组ori能否根据groupSize中因数完成题目的条件
    public boolean isGroup(List<Integer> groupSize,int[] ori){
        if (groupSize == null || groupSize.isEmpty()){
            return false;
        }
        a:for (int size : groupSize){
            //数组长度不能整除因数，肯定不满足条件，直接判断下一因数
            if (ori.length % size != 0){
                continue a;
            }
            int first = ori[0];
            for (int i = 1; i < ori.length; i++) {
                if (i % size != 0){
                    //按照因数大小分割的数组中有长得不一样的整数，不满足条件，判断下一因数
                    if (ori[i] != first) continue a;
                }else {
                    first = ori[i];
                }
            }
            //因为该题是判断能否满足题目条件，所以上面的for循环只要完整循环一次，就代表这个因数满足了条件，返回true即可
            return true;
        }
        //没有因数满足条件，返回false
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasGroupsSizeX(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,4,4,4,4,4,5,5,5,5,5}));
//        System.out.println(solution.isGroup(new int[]{5},new int[]{1,1,1,1,2,2,2,2,2,2}));
//        solution.isGroup(solution.num(6),new int[]{1,1,1,1});
    }
}
