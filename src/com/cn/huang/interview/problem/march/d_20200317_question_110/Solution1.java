/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.interview.problem.march.d_20200317_question_110;

/**
 * @author huangzuo
 * @version : Solution1.java, v 0.1 2020年03月18日 12:15 上午 huangzuo Exp $
 */
public class Solution1 {
    public static class TreeNode {
        int val;
        Solution1.TreeNode left;
        Solution1.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static boolean isBalanced(TreeNode root){
        return recur(root) != -1;
    }

    private static int recur(TreeNode root){
        if (root == null) {
            return 0;
        }
        //左子节点高度
        int left = recur(root.left);
        if (left == -1){
            return -1;
        }

        //右子节点高度
        int right = recur(root.right);
        if (right == -1){
            return -1;
        }

//        System.out.println("根节点是 " + root.val + "的左节点高度是 ： " +left);
//        System.out.println("根节点是 " + root.val + "的右节点高度是 ： " +right);
//        System.out.println("根节点的高度是 " + (Math.abs(left-right) < 2 ? Math.max(left,right)+1 : -1));


        return (Math.abs(left-right) < 2 ? Math.max(left,right)+1 : -1);
    }

    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]
//        TreeNode root = new TreeNode(3);
//        TreeNode left1 = new TreeNode(9);
//        TreeNode right1 = new TreeNode(20);
//        TreeNode right11 = new TreeNode(15);
//        TreeNode right12 = new TreeNode(7);
//
//        root.left = left1;
//        root.right = right1;
//        right1.left = right11;
//        right1.right = right12;

//        [1,2,2,3,3,null,null,4,4]

        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode left11 = new TreeNode(3);
        TreeNode left12 = new TreeNode(3);
        TreeNode left111 = new TreeNode(4);
        TreeNode left112 = new TreeNode(4);
        TreeNode right1 = new TreeNode(2);

        root.left = left1;
        root.right = right1;
        left1.left = left11;
        left1.right = left12;
        left11.left = left111;
        left11.right = left112;


        System.out.println(isBalanced(root));
    }
}
