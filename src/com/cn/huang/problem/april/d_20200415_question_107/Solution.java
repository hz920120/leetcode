/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200415_question_107;

import com.cn.huang.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月15日 10:44 下午 huangzuo Exp $
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){return res;}

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                tmp.add(treeNode.val);
                if (treeNode.right != null){
                    queue.offer(treeNode.right);
                }
                if (treeNode.left != null){
                    queue.offer(treeNode.left);
                }
            }
            res.add(0,tmp);
        }

        return res;
    }
}