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

        int res = 1;
        //均没有子节点：为叶子节点，返回0
        if (root.right == null && root.left == null){
            return 1;
        }
        //均有子节点：取左右叶子节点的最小深度
        if (root.left != null && root.right!=null){
            res = res + Math.min(minDepth(root.left),minDepth(root.right)) ;
        }
        //缺少其中一个子节点：取左右子节点的最大深度
        if (root.left == null || root.right == null){
            res = res + Math.max(minDepth(root.left),minDepth(root.right)) ;
        }


        return res;

    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.mkTree("[3,9,20,null,null,15,7]");
        Solution solution = new Solution();
        System.out.println(solution.minDepth(treeNode));
    }
}
