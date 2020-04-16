/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200416_question_404;

import com.cn.huang.utils.TreeNode;

/**
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月17日 12:19 上午 huangzuo Exp $
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){return 0;}
        int res = 0;
        if (root.left == null && root.right == null){
            return res;
        }
        if (root.right != null && !isLeaf(root.right)){
            res += sumOfLeftLeaves(root.right);
        }
        if (root.left != null && !isLeaf(root.left)){
            res += sumOfLeftLeaves(root.left);
        }
        if (root.left != null && isLeaf(root.left)){
            res += root.left.val;
        }
        return res;
    }

    /**
     * @param node
     * @return
     */
    private boolean isLeaf(TreeNode node){
        if (node.left == null && node.right == null){
            return true;
        }
        return false;
    }
}
