/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.september;

import com.cn.huang.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author huangzuo
 * @version : q257.java, v 0.1 2020年09月04日 10:02 上午 huangzuo Exp $
 */
public class q257 {
    private static final String array = "->";
    private List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        if (root == null) {
            return res;
        }

        findNodes(root,"");
        return res;
    }

    void findNodes(TreeNode node, String str) {
        //叶子节点的左右节点都为空，为添加到res的条件
        if (node.left == null && node.right == null) {
            str += (array + node.val);
            res.add(str.substring(2));
            return;
        }
        str += (array + node.val);
        if (node.left != null) {
            findNodes(node.left,str);
        }

        if (node.right != null) {
            findNodes(node.right,str);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.mkTree("[1,2,3,null,5]");
        q257 q257 = new q257();
        q257.binaryTreePaths(treeNode);
    }
}
