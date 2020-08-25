/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huangzuo
 * @version : q46.java, v 0.1 2020年08月25日 12:50 下午 huangzuo Exp $
 */
public class q46 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        LinkedList<Integer> alreadyPath = new LinkedList<>();
        backTrace(nums,alreadyPath);
        return ans;
    }

    private void backTrace(int[] nums, LinkedList<Integer> alreadyPath) {
        //回溯终止条件
        if (alreadyPath.size() == nums.length) {
            ans.add(new LinkedList<>(alreadyPath));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //如果alreadyPath已经包含数字，则跳过
            if (alreadyPath.contains(nums[i])) {
                continue;
            }
            //添加数字
            alreadyPath.add(nums[i]);
            //继续寻找下一位数字
            backTrace(nums,alreadyPath);
            //找到一组结果后，需要返回上一节点，删除最后一位节点
            alreadyPath.removeLast();
        }
    }
}
