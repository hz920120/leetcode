/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.march.d_20200323_question_235;


import com.cn.huang.utils.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *  
 *
 * Example 1:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月24日 12:02 上午 huangzuo Exp $
 */
public class Solution {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //利用二叉树搜索树的性质：
        // 1若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
        // 2若任意节点的右子树不空，则右子树上所有节点的值均大于或等于它的根节点的值；
        // 3任意节点的左、右子树也分别为二叉查找树；
        if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }

    public static void main(String[] args) {
        String str = "[6,2,8,0,4,7,9,null,null,3,5]";
        TreeNode node = TreeNode.mkTree(str);

        lowestCommonAncestor(node,new TreeNode(3),new TreeNode(5));
    }
}
