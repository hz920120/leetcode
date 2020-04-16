/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200415_question_111;

import com.cn.huang.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月16日 12:06 上午 huangzuo Exp $
 */
public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null){return 0;}
        int left = leftDepth(root,1);
        int right = rightDepth(root,1);
        if (left == 1 || right == 1){
            return Math.max(left,right);
        }else {
            return Math.min(left,right);
        }
    }

    private int leftDepth(TreeNode treeNode,int dep){
        if (treeNode.left!=null){
            return leftDepth(treeNode.left,dep+1);
        }else {
            return dep;
        }
    }

    private int rightDepth(TreeNode treeNode,int dep){
        if (treeNode.right!=null){
            return rightDepth(treeNode.right,dep+1);
        }else {
            return dep;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.mkTree("[3,9,20,null,null,15,7]");
        Solution solution = new Solution();
        solution.minDepth(treeNode);
    }
}
