/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.tree;

import com.cn.huang.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * @author huangzuo
 * @version : MaxDepth.java, v 0.1 2020年05月26日 12:08 上午 huangzuo Exp $
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.mkTree("[0,2,4,1,null,3,-1,5,1,null,6,null,8]");
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.maxDepth(treeNode));
    }
}
