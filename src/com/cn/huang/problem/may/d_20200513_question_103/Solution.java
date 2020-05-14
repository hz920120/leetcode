/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.may.d_20200513_question_103;

import com.cn.huang.utils.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @author huangzuo
 * @version : d_20200513_question_103.java, v 0.1 2020年05月13日 11:47 下午 huangzuo Exp $
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                if (reverse){
                    list.add(0,treeNode.val);
                }else {
                    list.add(treeNode.val);
                }

                if (treeNode.left!=null){queue.offer(treeNode.left);}
                if (treeNode.right!=null){queue.offer(treeNode.right);}
            }
            res.add(list);
            reverse = !reverse;
        }
        return res;
    }

}
