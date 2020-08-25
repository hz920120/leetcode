/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

import com.cn.huang.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzuo
 * @version : q3.java, v 0.1 2020年08月23日 10:41 下午 huangzuo Exp $
 */
public class q113 {


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root,sum,new ArrayList<>(),result);
        return result;
    }

    private void dfs(TreeNode root, int sum, List<Integer> list,List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        //每次都需要新建一个list
        List<Integer> subList = new ArrayList<>(list);
        //放入当前节点的值
        subList.add(root.val);
        //遍历到叶子节点停止遍历
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                result.add(subList);
            }
            return;
        }

        dfs(root.left,sum- root.val, subList,result);
        dfs(root.right,sum- root.val,subList,result);
    }

}
