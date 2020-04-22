/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200422_question_199;

import com.cn.huang.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月22日 10:08 下午 huangzuo Exp $
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //判断一下特殊条件
        if (root == null){return res;}
        Queue<TreeNode> queue = new LinkedList<>();
        //根节点加入队列
        queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                //从前往后把队列中的结点poll出
                TreeNode node = queue.poll();
                //把这一层最后（右）的结点值放入list
                if (i == len -1) {
                    res.add(node.val);
                }
                //队列中加入下一层的结点
                if (node.left != null) {queue.offer(node.left);}
                if (node.right != null) {queue.offer(node.right);}
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.mkTree("[1,2,3,null,5,null,4]");
        List<Integer> res = solution.rightSideView(root);
        System.out.println(1);
    }
}
