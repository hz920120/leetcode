/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200415_question_102;

import com.cn.huang.utils.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月15日 11:54 下午 huangzuo Exp $
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res  = new ArrayList<>();
        if (root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                tmp.add(treeNode.val);
                if (treeNode.left!=null){
                    queue.offer(treeNode.left);
                }
                if (treeNode.right!=null){
                    queue.offer(treeNode.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
    }
}
