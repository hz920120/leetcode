/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200416_question_104;

import com.cn.huang.utils.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
 * return its depth = 3.
 *
 * @author huangzuo
 * @version : d_20200415_question_104.java, v 0.1 2020年04月16日 11:36 下午 huangzuo Exp $
 */
public class Solution {
    /**
     * 此题类似111，111为求最小深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {return 0;}

        //如果左右节点均为空，满足叶子节点的条件，节点数+1
        if (root.left == null && root.right == null){return 1;}
        //如果左右节点均不为空，则返回左右子节点的最大深度
        //如果只有其中一个子节点为空，则返回最大深度
        //+1表示根节点也要算进去
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
